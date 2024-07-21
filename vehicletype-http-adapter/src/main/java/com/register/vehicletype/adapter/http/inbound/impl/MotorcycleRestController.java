package com.register.vehicletype.adapter.http.inbound.impl;

import com.register.vehicletype.adapter.http.inbound.IRestController;
import com.register.vehicletype.domain.dto.MotorcycleDTO;
import com.register.vehicletype.domain.port.inbound.IServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * The MotorcycleRestController class represents a REST controller for managing motorcycle entities.
 * It implements the IRestController interface, which defines methods for saving, deleting, finding by ID,
 * and retrieving motorcycle entities.
 */
@RestController
@RequestMapping(path = "/api/v1/motorcycle")
public class MotorcycleRestController implements IRestController<MotorcycleDTO, Long> {

    private final IServicePort<MotorcycleDTO, Long> motorcycleServicePort;

    /**
     * The MotorcycleRestController class represents a REST controller for managing motorcycle entities.
     * It implements the IRestController interface, which defines methods for saving, deleting, finding by ID,
     * and retrieving motorcycle entities.
     */
    public MotorcycleRestController(IServicePort<MotorcycleDTO, Long> motorcycleServicePort) {
        this.motorcycleServicePort = motorcycleServicePort;
    }

    /**
     * Saves a motorcycle.
     *
     * @param motorcycleDTO the motorcycle to save
     * @return a ResponseEntity containing the saved motorcycle if the save operation is successful
     */
    @Override
    public ResponseEntity<MotorcycleDTO> save(MotorcycleDTO motorcycleDTO) {
        return ResponseEntity.ok(motorcycleServicePort.save(motorcycleDTO));
    }

    /**
     * Deletes a motorcycle with the specified ID.
     *
     * @param motorcycleId the ID of the motorcycle to delete
     * @return a ResponseEntity with an empty body and HTTP 200 status if the motorcycle is successfully deleted,
     *         or a ResponseEntity with an empty body and HTTP 303 status if the motorcycle is not found
     */
    @Override
    public ResponseEntity<String> delete(Long motorcycleId) {
        boolean isMotorcycleDeleted = motorcycleServicePort.delete(motorcycleId);
        if(isMotorcycleDeleted) {
            return ResponseEntity.ok("Motorcycle with ID " + motorcycleId + " deleted.");
        }
        return new ResponseEntity<>("Unable to delete motorcycle with ID " + motorcycleId, HttpStatus.SEE_OTHER);
    }

    /**
     * Finds a motorcycle by its ID.
     *
     * @param motorcycleId the ID of the motorcycle to find.
     * @return a ResponseEntity containing the MotorcycleDTO object if found, or an HTTP 404 status if not found.
     */
    @Override
    public ResponseEntity<MotorcycleDTO> findById(Long motorcycleId) {
        return ResponseEntity.ok(motorcycleServicePort.findById(motorcycleId));
    }

    /**
     * Retrieves all motorcycles from the collection, ordered by make in ascending order.
     *
     * @return a ResponseEntity containing a collection of MotorcycleDTO objects,
     *         ordered by make in ascending order.
     */
    @Override
    public ResponseEntity<Collection<MotorcycleDTO>> findAllByOrderByMakeAsc() {
        return ResponseEntity.ok(motorcycleServicePort.findAllByOrderByMakeAsc());
    }
}
