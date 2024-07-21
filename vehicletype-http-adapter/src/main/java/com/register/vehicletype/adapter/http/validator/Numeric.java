package com.register.vehicletype.adapter.http.validator;

import com.register.vehicletype.adapter.http.validator.impl.NumericValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The {@code Numeric} annotation is used to mark a parameter as requiring a numeric value.
 * It is used in conjunction with the {@link NumericValidatorImpl} class to validate whether a given value is numeric or not.
 * If the value is not numeric, a validation error with the default message "Input must be numeric" is raised.
 *
 * <p>Usage example:</p>
 * <pre>{@code
 *  /**
 *   * Deletes a truck with the specified ID.
 *   *
 *   * @param truckId the ID of the truck to delete
 *   * @return a ResponseEntity containing a success message if the truck is deleted, otherwise an error message
 *   *\/
 *  @Override
 *  public ResponseEntity<String> delete(@Numeric Long truckId) {
 *      boolean isTruckDeleted = truckServicePort.delete(truckId);
 *      if(isTruckDeleted) {
 *          return ResponseEntity.ok("Truck with ID " + truckId + " deleted.");
 *      }
 *      return new ResponseEntity<>("Unable to delete truck with ID " + truckId, HttpStatus.SEE_OTHER);
 *  }
 * }</pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Constraint(validatedBy = NumericValidatorImpl.class)
@Documented
public @interface Numeric {
    String message() default "Input must be numeric";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
