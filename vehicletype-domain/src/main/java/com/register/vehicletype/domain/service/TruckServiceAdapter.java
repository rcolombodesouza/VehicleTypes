package com.register.vehicletype.domain.service;

import com.register.vehicletype.domain.dto.TruckDTO;
import com.register.vehicletype.domain.event.VehicleDeletedEvent;
import com.register.vehicletype.domain.event.VehicleSavedEvent;
import com.register.vehicletype.domain.port.inbound.IServicePort;
import com.register.vehicletype.domain.port.outbound.IRepositoryPort;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Collection;

/**
 * Constructs a TruckServiceAdapter object with the specified repository port and event publisher.
 */
public class TruckServiceAdapter implements IServicePort<TruckDTO, Long> {

    private final IRepositoryPort<TruckDTO, Long> truckRepositoryPort;
    private final ApplicationEventPublisher applicationEventPublisher;

    /**
     * The TruckServiceAdapter class is an implementation of the IServicePort interface
     * for managing TruckDTO entities. It provides methods for saving, deleting, finding by ID,
     * and retrieving all TruckDTO entities. It uses a TruckRepositoryPort and an ApplicationEventPublisher
     * internally for performing the operations.
     *
     * @param truckRepositoryPort         the repository port for TruckDTO entities
     * @param applicationEventPublisher   the event publisher for application events
     */
    public TruckServiceAdapter(IRepositoryPort<TruckDTO, Long> truckRepositoryPort,
                             ApplicationEventPublisher applicationEventPublisher) {
        this.truckRepositoryPort = truckRepositoryPort;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * Saves a TruckDTO object.
     *
     * @param truckDTO the TruckDTO object to be saved
     * @return the saved TruckDTO object
     */
    @Override
    public TruckDTO save(TruckDTO truckDTO) {
        TruckDTO savedTruckDTO = truckRepositoryPort.save(truckDTO);
        applicationEventPublisher.publishEvent(new VehicleSavedEvent<>(this, savedTruckDTO));
        return savedTruckDTO;
    }

    /**
     * Deletes a truck with the specified ID.
     *
     * @param truckId the ID of the truck to delete
     * @return true if the truck was successfully deleted, false otherwise
     */
    @Override
    public boolean delete(Long truckId) {
        boolean isTruckDeleted = truckRepositoryPort.delete(truckId);
        applicationEventPublisher.publishEvent(new VehicleDeletedEvent<>(this, isTruckDeleted));
        return isTruckDeleted;
    }

    /**
     * Retrieves a TruckDTO object by its ID.
     *
     * @param truckId the ID of the truck to retrieve
     * @return the TruckDTO object with the specified ID, or null if not found
     */
    @Override
    public TruckDTO findById(Long truckId) {
        return truckRepositoryPort.findById(truckId);
    }

    /**
     * Retrieves all trucks from the repository in ascending order of their make.
     *
     * @return a collection of TruckDTO objects, ordered by make in ascending order
     */
    @Override
    public Collection<TruckDTO> findAllByOrderByMakeAsc(int page, int size) {
        return truckRepositoryPort.findAllByOrderByMakeAsc(page, size);
    }
}
