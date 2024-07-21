package com.register.vehicletype.domain.exception;

/**
 * The MotorcycleNotFoundException class is a custom exception that is thrown when a motorcycle
 * with the specified ID is not found.
 */
public class MotorcycleNotFoundException extends RuntimeException {

    /**
     * Constructs a new MotorcycleNotFoundException with the specified book ID.
     *
     * @param value the ID of the motorcycle that was not found
     */
    public MotorcycleNotFoundException(Object value) {
        super("Could not find motorcycle with id " + value);
    }
}