package com.register.vehicletype.domain.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;

/**
 * The TruckDTO class represents a data transfer object for a Truck entity.
 * It contains the ID, make, model, year, and payload capacity of the truck.
 */
public record TruckDTO(Long id,
                       @NotNull(message = "Make cannot be null.") @NotEmpty(message = "Make cannot be empty.") String make,
                       @NotNull(message = "Model cannot be null.") @NotEmpty(message = "Model cannot be empty.") String model,
                       @NotNull(message = "Year cannot be null.") Integer year,
                       @Positive @Digits(integer = 5, fraction = 2, message = "Payload capacity must be a number") double payloadCapacity) implements Serializable {
}
