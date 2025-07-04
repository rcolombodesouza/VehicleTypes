package com.register.vehicletype.adapter.db.outbound;

import com.register.vehicletype.adapter.db.entity.CarEntity;
import com.register.vehicletype.adapter.db.repository.CarRepository;
import com.register.vehicletype.domain.dto.CarDTO;
import com.register.vehicletype.domain.dto.TruckDTO;
import com.register.vehicletype.domain.exception.CarNotFoundException;
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
 * The CarRepositoryAdapter class is an adapter class that implements the IRepositoryPort interface
 * for the CarDTO class and the Long type.
 * It provides CRUD operations for car entities using a CarRepository and a ModelMapper.
 */

@CacheConfig(cacheNames = "cars")
public class CarRepositoryAdapter implements IRepositoryPort<CarDTO, Long> {

    private final CarRepository carRepository;
    private final ConversionService conversionService;

    /**
     * The CarRepositoryAdapter class is an adapter class that implements the IRepositoryPort interface
     * for the CarDTO class and the Long type.
     * It provides CRUD operations for car entities using a CarRepository and a ModelMapper.
     */
    public CarRepositoryAdapter(CarRepository carRepository, ConversionService conversionService) {
        this.carRepository = carRepository;
        this.conversionService = conversionService;
    }

    /**
     * Retrieves a car DTO object by its ID.
     *
     * @param id the ID of the carDTO to retrieve
     * @return the carDTO object with the specified ID
     * @throws CarNotFoundException if a car with the specified ID is not found in the repository
     */
    @Override
    @Cacheable(key = "#id")
    @Transactional(readOnly = true)
    public CarDTO findById(Long id) {
        CarEntity carEntity = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        return conversionService.convert(carEntity, CarDTO.class);
    }

    /**
     * Retrieves a list of CarDTO objects from the car repository, ordered by make in ascending order.
     *
     * @return a list of CarDTO objects ordered by make
     */
    @Override
    @Transactional(readOnly = true)
    public List<CarDTO> findAllByOrderByMakeAsc(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CarEntity> carEntities = carRepository.findAll(pageable);
        return carEntities.stream()
                .map(carEntity -> conversionService.convert(carEntity, CarDTO.class))
                .toList();
    }

    /**
     * Saves a car entity to the repository.
     *
     * @param carDTO the carDTO object representing the car entity to be saved
     * @return the saved car entity as a CarDTO object
     */
    @Override
    @CachePut(key = "#result.id()")
    @Transactional
    public CarDTO save(CarDTO carDTO) {
        CarEntity carEntity = conversionService.convert(carDTO, CarEntity.class);
        CarEntity savedCarEntity = carRepository.save(carEntity);
        return conversionService.convert(savedCarEntity, CarDTO.class);
    }

    /**
     * Deletes a car entity from the repository based on the ID.
     *
     * @param id the ID of the car entity to be deleted
     * @return true if the car entity is successfully deleted, false otherwise
     * @throws CarNotFoundException if a car with the specified ID is not found in the repository
     */
    @Override
    @CacheEvict(key = "#id")
    @Transactional
    public boolean delete(Long id) {
        if(!carRepository.existsById(id)) {
            throw new CarNotFoundException(id);
        }
        carRepository.deleteById(id);
        return true;
    }
}
