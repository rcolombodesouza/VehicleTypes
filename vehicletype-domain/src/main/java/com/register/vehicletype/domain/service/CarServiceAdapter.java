package com.register.vehicletype.domain.service;

import com.register.vehicletype.domain.dto.CarDTO;
import com.register.vehicletype.domain.event.VehicleDeletedEvent;
import com.register.vehicletype.domain.event.VehicleSavedEvent;
import com.register.vehicletype.domain.port.inbound.IServicePort;
import com.register.vehicletype.domain.port.outbound.IRepositoryPort;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Collection;

/**
 * The CarServiceAdapter class is an adapter that implements the IServicePort interface for managing CarDTO entities.
 * It provides methods for saving, deleting, finding by ID, and retrieving all CarDTO objects.
 */
public class CarServiceAdapter implements IServicePort<CarDTO, Long> {

    private final IRepositoryPort<CarDTO, Long> carRepositoryPort;
    private final ApplicationEventPublisher applicationEventPublisher;

    /**
     * The CarServiceAdapter class is an adapter that implements the IServicePort interface for managing CarDTO entities.
     * It provides methods for saving, deleting, finding by ID, and retrieving all CarDTO objects.
     *
     * @param carRepositoryPort            the repository port for CarDTO entities
     * @param applicationEventPublisher    the publisher for application events
     */
    public CarServiceAdapter(IRepositoryPort<CarDTO, Long> carRepositoryPort,
                             ApplicationEventPublisher applicationEventPublisher) {
        this.carRepositoryPort = carRepositoryPort;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * Saves a car DTO.
     *
     * @param carDTO the car DTO to be saved
     * @return the saved car DTO
     */
    @Override
    public CarDTO save(CarDTO carDTO) {
        CarDTO savedCarDTO = carRepositoryPort.save(carDTO);
        applicationEventPublisher.publishEvent(new VehicleSavedEvent<>(this, savedCarDTO));
        return savedCarDTO;
    }

    /**
     * Deletes a car with the specified ID.
     *
     * @param carId the ID of the car to delete
     * @return true if the car was successfully deleted, false otherwise
     */
    @Override
    public boolean delete(Long carId) {
        boolean isCarDeleted = carRepositoryPort.delete(carId);
        applicationEventPublisher.publishEvent(new VehicleDeletedEvent<>(this, isCarDeleted));
        return isCarDeleted;
    }

    /**
     * Finds a car by its ID.
     *
     * @param carId the ID of the car to find
     * @return the found car, or null if not found
     */
    @Override
    public CarDTO findById(Long carId) {
        return carRepositoryPort.findById(carId);
    }

    /**
     * Retrieves a collection of CarDTO objects from the carRepositoryPort, ordered by make in ascending order.
     *
     * @return a collection of CarDTO objects, ordered by make in ascending order
     */
    @Override
    public Collection<CarDTO> findAllByOrderByMakeAsc(int page, int size) {
        return carRepositoryPort.findAllByOrderByMakeAsc(page, size);
    }
}
