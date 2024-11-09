package com.register.vehicletype.adapter.db.outbound;

import com.register.vehicletype.adapter.db.entity.TruckEntity;
import com.register.vehicletype.adapter.db.repository.TruckRepository;
import com.register.vehicletype.domain.dto.TruckDTO;
import com.register.vehicletype.domain.exception.TruckNotFoundException;
import com.register.vehicletype.domain.port.outbound.IRepositoryPort;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * The TruckRepositoryAdapter class is an adapter that implements the IRepositoryPort interface for the TruckDTO class
 * and provides CRUD operations for Truck entities using the underlying TruckRepository and ModelMapper.
 */
@CacheConfig(cacheNames = "trucks")
public class TruckRepositoryAdapter implements IRepositoryPort<TruckDTO, Long> {

    private final TruckRepository truckRepository;
    private final ConversionService conversionService;

    /**
     * The TruckRepositoryAdapter class is an implementation of the IRepositoryPort interface
     * that is responsible for managing TruckDTO objects using TruckRepository and ConversionService.
     */
    public TruckRepositoryAdapter(TruckRepository truckRepository, ConversionService conversionService) {
        this.truckRepository = truckRepository;
        this.conversionService = conversionService;
    }

    /**
     * Finds a TruckDTO object by its ID.
     *
     * @param id the ID of the truck to find
     * @return the found TruckDTO object
     * @throws TruckNotFoundException if the truck with the specified ID is not found
     */
    @Override
    @Cacheable(key = "#id")
    @Transactional(readOnly = true)
    public TruckDTO findById(Long id) {
        TruckEntity truckEntity = truckRepository.findById(id).orElseThrow(() -> new TruckNotFoundException(id));
        return conversionService.convert(truckEntity, TruckDTO.class);
    }

    /**
     * Retrieves a list of trucks from the repository, ordered by make in ascending order.
     *
     * @return a list of TruckDTO objects ordered by make
     */
    @Override
    @Transactional(readOnly = true)
    public List<TruckDTO> findAllByOrderByMakeAsc() {
        Collection<TruckEntity> allTrucksOrderedByMakeAsc = truckRepository.findAllByOrderByMakeAsc();
        return allTrucksOrderedByMakeAsc.stream()
                .map(truckEntity -> conversionService.convert(truckEntity, TruckDTO.class)).toList();
    }

    /**
     * Saves a truck DTO object.
     *
     * @param truckDTO the truck DTO object to be saved
     * @return the saved truck DTO object
     */
    @Override
    @CachePut(key = "#result.id()")
    @Transactional
    public TruckDTO save(TruckDTO truckDTO) {
        TruckEntity truckEntity = conversionService.convert(truckDTO, TruckEntity.class);
        TruckEntity savedTruckEntity = truckRepository.save(truckEntity);
        return conversionService.convert(savedTruckEntity, TruckDTO.class);
    }

    /**
     * Deletes a truck with the specified ID.
     *
     * @param id the ID of the truck to delete
     * @return true if the truck was deleted successfully, false otherwise
     * @throws TruckNotFoundException if the truck with the specified ID is not found
     */
    @Override
    @CacheEvict(key = "#id")
    @Transactional
    public boolean delete(Long id) {
        if(truckRepository.existsById(id)) {
            truckRepository.deleteById(id);
            return !truckRepository.existsById(id);
        }
        throw new TruckNotFoundException(id);
    }
}