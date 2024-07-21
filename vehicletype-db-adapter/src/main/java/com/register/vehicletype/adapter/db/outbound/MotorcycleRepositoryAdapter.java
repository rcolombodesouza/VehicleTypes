package com.register.vehicletype.adapter.db.outbound;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.register.vehicletype.adapter.db.entity.MotorcycleEntity;
import com.register.vehicletype.adapter.db.repository.MotorcycleRepository;
import com.register.vehicletype.domain.dto.MotorcycleDTO;
import com.register.vehicletype.domain.exception.MotorcycleNotFoundException;
import com.register.vehicletype.domain.port.outbound.IRepositoryPort;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    private final ObjectMapper objectMapper;

    /**
     * The MotorcycleRepositoryAdapter is an adapter class that implements the IRepositoryPort interface
     * for the MotorcycleDTO class. It provides CRUD operations for managing MotorcycleDTO objects in the
     * database through the MotorcycleRepository.
     */
    public MotorcycleRepositoryAdapter(MotorcycleRepository motorcycleRepository, ObjectMapper objectMapper) {
        this.motorcycleRepository = motorcycleRepository;
        this.objectMapper = objectMapper;
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
        return objectMapper.convertValue(motorcycleEntity, MotorcycleDTO.class);
    }

    /**
     * Retrieves a list of motorcycles from the repository ordered by make in ascending order.
     *
     * @return the list of motorcycles ordered by make
     */
    @Override
    @Transactional(readOnly = true)
    public List<MotorcycleDTO> findAllByOrderByMakeAsc() {
        Collection<MotorcycleEntity> allMotorcyclesOrderedByMakeAsc = motorcycleRepository.findAllByOrderByMakeAsc();
        return allMotorcyclesOrderedByMakeAsc.stream()
                .map(motorcycleEntity -> objectMapper.convertValue(motorcycleEntity, MotorcycleDTO.class)).toList();
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
        MotorcycleEntity motorcycleEntity = objectMapper.convertValue(motorcycleDTO, MotorcycleEntity.class);
        MotorcycleEntity savedMotorcycleEntity = motorcycleRepository.save(motorcycleEntity);
        return objectMapper.convertValue(savedMotorcycleEntity, MotorcycleDTO.class);
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
