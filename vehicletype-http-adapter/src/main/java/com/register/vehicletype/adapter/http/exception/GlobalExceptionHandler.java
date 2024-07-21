package com.register.vehicletype.adapter.http.exception;

import com.register.vehicletype.domain.exception.CarNotFoundException;
import com.register.vehicletype.domain.exception.MotorcycleNotFoundException;
import com.register.vehicletype.domain.exception.TruckNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * The GlobalExceptionHandler class is a controller advice class that handles exceptions thrown by controllers within the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles the MotorcycleNotFoundException by creating a custom error response and returning it as a ResponseEntity.
     *
     * @param motorcycleNotFoundException The MotorcycleNotFoundException to be handled.
     * @return A ResponseEntity containing the custom error response and the appropriate HTTP status code.
     */
    @ExceptionHandler(MotorcycleNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleMotorcycleNotFoundException(MotorcycleNotFoundException motorcycleNotFoundException) {
        Map<String, String> errorsMap = new HashMap<>();
        errorsMap.put("Motorcycle", motorcycleNotFoundException.getMessage());
        return getCustomResponseEntity(errorsMap, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles the TruckNotFoundException by creating a custom error response and returning it as a ResponseEntity.
     *
     * @param truckNotFoundException The TruckNotFoundException to be handled.
     * @return A ResponseEntity containing the custom error response and the appropriate HTTP status code.
     */
    @ExceptionHandler(TruckNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleTruckNotFoundException(TruckNotFoundException truckNotFoundException) {
        Map<String, String> errorsMap = new HashMap<>();
        errorsMap.put("Truck", truckNotFoundException.getMessage());
        return getCustomResponseEntity(errorsMap, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles the CarNotFoundException by creating a custom error response and returning it as a ResponseEntity.
     *
     * @param carNotFoundException The CarNotFoundException to be handled.
     * @return A ResponseEntity containing the custom error response and the appropriate HTTP status code.
     */
    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleCarNotFoundException(CarNotFoundException carNotFoundException) {
        Map<String, String> errorsMap = new HashMap<>();
        errorsMap.put("Car", carNotFoundException.getMessage());
        return getCustomResponseEntity(errorsMap, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles the MethodArgumentNotValidException by creating a custom error response and returning it as a ResponseEntity.
     *
     * @param methodArgumentNotValidException      The MethodArgumentNotValidException to be handled.
     * @return A ResponseEntity containing the custom error response and the appropriate HTTP status code.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<CustomErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return getCustomResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Returns a ResponseEntity object containing a custom error response.
     *
     * @param errorsMap the error messages to be included in the response body
     * @return a ResponseEntity object containing the custom error response and the appropriate HTTP status code
     */
    private ResponseEntity<CustomErrorResponse> getCustomResponseEntity(Map<String, String> errorsMap, HttpStatus httpStatus) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setErrors(errorsMap);
        errors.setStatus(httpStatus.value());
        return new ResponseEntity<>(errors, httpStatus);
    }
}
