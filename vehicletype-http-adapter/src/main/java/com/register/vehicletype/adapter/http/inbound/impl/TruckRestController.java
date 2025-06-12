package com.register.vehicletype.adapter.http.inbound.impl;

import com.register.vehicletype.adapter.http.inbound.IRestController;
import com.register.vehicletype.domain.dto.TruckDTO;
import com.register.vehicletype.domain.port.inbound.IServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * This class represents a REST controller for managing TruckDTO entities.
 * It provides endpoints for saving, deleting, finding by ID, and retrieving all TruckDTO entities.
 */
@RestController
@RequestMapping(path = "/api/v1/truck")
public class TruckRestController implements IRestController<TruckDTO, Long> {

    private final IServicePort<TruckDTO, Long> truckServicePort;

    /**
     * This class represents a REST controller for managing TruckDTO entities.
     * It provides endpoints for saving, deleting, finding by ID, and retrieving all TruckDTO entities.
     */
    public TruckRestController(IServicePort<TruckDTO, Long> truckServicePort) {
        this.truckServicePort = truckServicePort;
    }

    /**
     * Saves a TruckDTO entity.
     *
     * @param truckDTO the TruckDTO entity to be saved
     * @return a ResponseEntity containing the saved TruckDTO entity if the save operation is successful
     */
    @Override
    public ResponseEntity<TruckDTO> save(TruckDTO truckDTO) {
        return ResponseEntity.ok(truckServicePort.save(truckDTO));
    }

    /**
     * Deletes a truck with the specified ID.
     *
     * @param truckId the ID of the truck to delete
     * @return a ResponseEntity containing a success message if the truck is deleted, otherwise an error message
     */
    @Override
    public ResponseEntity<String> delete(Long truckId) {
        boolean isTruckDeleted = truckServicePort.delete(truckId);
        if(isTruckDeleted) {
            return ResponseEntity.ok("Truck with ID " + truckId + " deleted.");
        }
        return new ResponseEntity<>("Unable to delete truck with ID " + truckId, HttpStatus.SEE_OTHER);
    }

    /**
     * Finds a TruckDTO entity by its ID.
     *
     * @param truckId the ID of the TruckDTO entity to find
     * @return a ResponseEntity containing the TruckDTO entity if found, or an HTTP 404 status if not found
     */
    @Override
    public ResponseEntity<TruckDTO> findById(Long truckId) {
        return ResponseEntity.ok(truckServicePort.findById(truckId));
    }

    /**
     * Retrieves all TruckDTO entities from the collection, ordered by make in ascending order.
     *
     * @return a ResponseEntity containing a collection of TruckDTO entities
     */
    @Override
    public ResponseEntity<Collection<TruckDTO>> findAllByOrderByMakeAsc(int page, int size) {
        return ResponseEntity.ok(truckServicePort.findAllByOrderByMakeAsc(page, size));
    }
}
