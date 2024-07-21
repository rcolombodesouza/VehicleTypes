package com.register.vehicletype.domain.exception;


/**
 * The TruckNotFoundException is an exception thrown when a truck is not found.
 */
public class TruckNotFoundException extends RuntimeException {

    /**
     * Exception thrown when a truck is not found.
     *
     * @param value The ID of the truck that was not found.
     */
    public TruckNotFoundException(Object value) {
        super("Could not find truck with id " + value);
    }
}
