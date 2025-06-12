package com.register.vehicletype.adapter.db.outbound;

import com.register.vehicletype.adapter.db.entity.CarEntity;
import com.register.vehicletype.adapter.db.entity.MotorcycleEntity;
import com.register.vehicletype.adapter.db.repository.MotorcycleRepository;
import com.register.vehicletype.domain.dto.CarDTO;
import com.register.vehicletype.domain.dto.MotorcycleDTO;
import com.register.vehicletype.domain.exception.MotorcycleNotFoundException;
import com.register.vehicletype.domain.port.outbound.IRepositoryPort;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * The MotorcycleRepositoryAdapter is an adapter class that implements the IRepositoryPort interface
 * for the MotorcycleDTO class. It provides CRUD operations for managing MotorcycleDTO objects in the
 * database through the MotorcycleRepository.
 */
@CacheConfig(cacheNames = "motorcycles")
public class MotorcycleRepositoryAdapter implements IRepositoryPort<MotorcycleDTO, Long> {

    private final MotorcycleRepository motorcycleRepository;
    private final ConversionService conversionService;

    /**
     * The MotorcycleRepositoryAdapter is an adapter class that implements the IRepositoryPort interface
     * for the MotorcycleDTO class. It provides CRUD operations for managing MotorcycleDTO objects in the
     * database through the MotorcycleRepository.
     */
    public MotorcycleRepositoryAdapter(MotorcycleRepository motorcycleRepository, ConversionService conversionService) {
        this.motorcycleRepository = motorcycleRepository;
        this.conversionService = conversionService;
    }

    /**
     * Finds a MotorcycleDTO by its ID.
     *
     * @param id the ID of the MotorcycleDTO to find
     * @return the found MotorcycleDTO
     * @throws MotorcycleNotFoundException if the MotorcycleDTO with the specified ID is not found
     */
    @Override
    @Cacheable(key = "#id")
    @Transactional(readOnly = true)
    public MotorcycleDTO findById(Long id) {
        MotorcycleEntity motorcycleEntity = motorcycleRepository.findById(id).orElseThrow(() -> new MotorcycleNotFoundException(id));
        return conversionService.convert(motorcycleEntity, MotorcycleDTO.class);
    }

    /**
     * Retrieves a list of motorcycles from the repository ordered by make in ascending order.
     *
     * @return the list of motorcycles ordered by make
     */
    @Override
    @Transactional(readOnly = true)
    public List<MotorcycleDTO> findAllByOrderByMakeAsc(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MotorcycleEntity> motorcycleEntities = motorcycleRepository.findAll(pageable);
        return motorcycleEntities.stream()
                .map(motorcycleEntity -> conversionService.convert(motorcycleEntity, MotorcycleDTO.class))
                .toList();
    }

    /**
     * Saves a motorcycle in the repository.
     *
     * @param motorcycleDTO the motorcycle object to be saved
     * @return the saved motorcycle as a MotorcycleDTO
     */
    @Override
    @CachePut(key = "#result.id()")
    @Transactional
    public MotorcycleDTO save(MotorcycleDTO motorcycleDTO) {
        MotorcycleEntity motorcycleEntity = conversionService.convert(motorcycleDTO, MotorcycleEntity.class);
        MotorcycleEntity savedMotorcycleEntity = motorcycleRepository.save(motorcycleEntity);
        return conversionService.convert(savedMotorcycleEntity, MotorcycleDTO.class);
    }

    /**
     * Deletes a motorcycle with the specified ID.
     *
     * @param id the ID of the motorcycle to delete
     * @return true if the motorcycle was deleted successfully, false otherwise
     * @throws MotorcycleNotFoundException if the motorcycle with the specified ID is not found
     */
    @Override
    @CacheEvict(key = "#id")
    @Transactional
    public boolean delete(Long id) {
        if(motorcycleRepository.existsById(id)) {
            motorcycleRepository.deleteById(id);
            return !motorcycleRepository.existsById(id);
        }
        throw new MotorcycleNotFoundException(id);
    }
}
