package com.register.vehicletype.adapter.http.inbound.impl;

import com.register.vehicletype.adapter.http.inbound.IRestController;
import com.register.vehicletype.domain.dto.CarDTO;
import com.register.vehicletype.domain.port.inbound.IServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * The CarRestController class is a REST controller for managing CarDTO objects.
 * It implements the IRestController interface for defining the CRUD operations.
 */
@RestController
@Validated
@RequestMapping(path = "/api/v1/car")
public class CarRestController implements IRestController<CarDTO, Long> {

    private final IServicePort<CarDTO, Long> carServicePort;

    /**
     * The CarRestController class is a REST controller for managing CarDTO objects.
     * It implements the IRestController interface for defining the CRUD operations.
     */
    public CarRestController(IServicePort<CarDTO, Long> carServicePort) {
        this.carServicePort = carServicePort;
    }

    /**
     * Saves a car.
     *
     * @param carDTO the CarDTO object representing the car entity to be saved.
     * @return a ResponseEntity containing the saved CarDTO object if the save operation is successful.
     */
    @Override
    public ResponseEntity<CarDTO> save(CarDTO carDTO) {
        return ResponseEntity.ok(carServicePort.save(carDTO));
    }

    /**
     * Deletes a car with the specified ID.
     *
     * @param carId the ID of the car to delete.
     * @return a ResponseEntity with the status code 200 and a success message if the car is successfully deleted,
     *         or a ResponseEntity with the status code 303 and an error message if the car cannot be deleted.
     */
    @Override
    public ResponseEntity<String> delete(Long carId) {
        boolean isCarDeleted = carServicePort.delete(carId);
        if(isCarDeleted) {
            return ResponseEntity.ok("Car with ID " + carId + " deleted.");
        }
        return new ResponseEntity<>("Unable to delete car with ID " + carId, HttpStatus.SEE_OTHER);
    }

    /**
     * Finds a car by its ID.
     *
     * @param carId the ID of the car to find
     * @return a ResponseEntity<CarDTO> containing the car with the specified ID if found,
     *         or an HTTP 404 status if the car is not found
     */
    @Override
    public ResponseEntity<CarDTO> findById(Long carId) {
        return ResponseEntity.ok(carServicePort.findById(carId));
    }

    /**
     * Retrieves all entities from the collection, ordered by the make property in ascending order.
     *
     * @return a ResponseEntity containing a collection of CarDTO objects, ordered by make in ascending order.
     */
    @Override
    public ResponseEntity<Collection<CarDTO>> findAllByOrderByMakeAsc(int page, int size) {
        return ResponseEntity.ok(carServicePort.findAllByOrderByMakeAsc(page, size));
    }
}
