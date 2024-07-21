package com.register.vehicletype.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * The CarDTO class represents a Data Transfer Object for a car.
 *
 * @param id             the ID of the car
 * @param make           the make of the car
 * @param model          the model of the car
 * @param year           the year of the car
 * @param numberOfDoors  the number of doors of the car
 */
public record CarDTO(Long id,
                     @NotNull(message = "Make cannot be null.") @NotEmpty(message = "Make cannot be empty.") String make,
                     @NotNull(message = "Model cannot be null.") @NotEmpty(message = "Model cannot be empty.") String model,
                     @NotNull(message = "Year cannot be null.") Integer year,
                     @NotNull(message = "Number of doors cannot be null.") Integer numberOfDoors) implements Serializable {
}
