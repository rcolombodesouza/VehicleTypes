package com.register.vehicletype.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * The MotorcycleDTO class represents a Data Transfer Object (DTO) for a motorcycle.
 * It encapsulates the attributes of a motorcycle, such as its ID, make, model, year, and whether it has a sidecar.
 * MotorcycleDTO is used to transfer motorcycle data between different layers of the application.
 */
public record MotorcycleDTO(Long id,
                            @NotNull(message = "Make cannot be null.") @NotEmpty(message = "Make cannot be empty.") String make,
                            @NotNull(message = "Model cannot be null.") @NotEmpty(message = "Model cannot be empty.") String model,
                            @NotNull(message = "Year cannot be null.") Integer year,
                            @NotNull(message = "Has side car cannot be null") boolean hasSidecar) implements Serializable {
}
