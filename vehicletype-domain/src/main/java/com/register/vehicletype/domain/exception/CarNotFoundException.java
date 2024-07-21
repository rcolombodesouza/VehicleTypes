package com.register.vehicletype.domain.exception;

/**
 * CarNotFoundException is an exception that is thrown when a car with a specific value (such as an ID) is not found.
 */
public class CarNotFoundException extends RuntimeException {

    /**
     * CarNotFoundException is an exception that is thrown when a car with a specific value (such as an ID) is not found.
     *
     * @param value the value that was used to search for the car but couldn't be found
     */
    public CarNotFoundException(Object value) {
        super("Could not find car with id " + value);
    }
}