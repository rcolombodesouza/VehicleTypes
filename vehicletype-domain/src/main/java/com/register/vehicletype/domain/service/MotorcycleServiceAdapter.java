package com.register.vehicletype.domain.service;

import com.register.vehicletype.domain.dto.MotorcycleDTO;
import com.register.vehicletype.domain.event.VehicleDeletedEvent;
import com.register.vehicletype.domain.event.VehicleSavedEvent;
import com.register.vehicletype.domain.port.inbound.IServicePort;
import com.register.vehicletype.domain.port.outbound.IRepositoryPort;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Collection;

/**
 * The MotorcycleServiceAdapter class is an implementation of the IServicePort interface that provides methods for managing MotorcycleDTO entities.
 * It interacts with the IRepositoryPort implementation for MotorcycleDTO objects to perform CRUD operations and publishes application events.
 */
public class MotorcycleServiceAdapter implements IServicePort<MotorcycleDTO, Long> {

    private final IRepositoryPort<MotorcycleDTO, Long> motorcycleRepositoryPort;
    private final ApplicationEventPublisher applicationEventPublisher;

    /**
     * The MotorcycleServiceAdapter class is an implementation of the IServicePort interface that provides methods for managing MotorcycleDTO entities.
     * It interacts with the IRepositoryPort implementation for MotorcycleDTO objects to perform CRUD operations and publishes application events.
     */
    public MotorcycleServiceAdapter(IRepositoryPort<MotorcycleDTO, Long> motorcycleRepositoryPort,
                             ApplicationEventPublisher applicationEventPublisher) {
        this.motorcycleRepositoryPort = motorcycleRepositoryPort;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * Saves the MotorcycleDTO object into the repository and publishes a VehicleSavedEvent.
     *
     * @param motorcycleDTO the MotorcycleDTO object to be saved
     * @return the saved MotorcycleDTO object
     */
    @Override
    public MotorcycleDTO save(MotorcycleDTO motorcycleDTO) {
        MotorcycleDTO savedMotorcycleDTO = motorcycleRepositoryPort.save(motorcycleDTO);
        applicationEventPublisher.publishEvent(new VehicleSavedEvent<>(this, savedMotorcycleDTO));
        return savedMotorcycleDTO;
    }

    /**
     * Deletes a motorcycle with the specified ID.
     *
     * @param motorcycleId the ID of the motorcycle to delete
     * @return true if the motorcycle is successfully deleted, false otherwise
     */
    @Override
    public boolean delete(Long motorcycleId) {
        boolean isMotorcycleDeleted = motorcycleRepositoryPort.delete(motorcycleId);
        applicationEventPublisher.publishEvent(new VehicleDeletedEvent<>(this, isMotorcycleDeleted));
        return isMotorcycleDeleted;
    }

    /**
     * Finds a MotorcycleDTO object by its ID.
     *
     * @param motorcycleId the ID of the motorcycle to find
     * @return the found MotorcycleDTO object, or null if not found
     */
    @Override
    public MotorcycleDTO findById(Long motorcycleId) {
        return motorcycleRepositoryPort.findById(motorcycleId);
    }

    /**
     * Retrieves a collection of MotorcycleDTO objects from the repository in ascending order of their make.
     *
     * @return a collection of MotorcycleDTO objects ordered by make in ascending order.
     */
    @Override
    public Collection<MotorcycleDTO> findAllByOrderByMakeAsc(int page, int size) {
        return motorcycleRepositoryPort.findAllByOrderByMakeAsc(page, size);
    }
}
