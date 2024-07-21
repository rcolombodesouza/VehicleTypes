package com.register.vehicletype.adapter.http.validator.impl;

import com.register.vehicletype.adapter.http.validator.Numeric;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * NumericValidatorImpl is an implementation of the ConstraintValidator interface for the Numeric constraint.
 * It validates whether a given value is numeric or not.
 */
public class NumericValidatorImpl implements ConstraintValidator<Numeric, Object> {

    /**
     * Initializes the NumericValidatorImpl instance with the specified constraint annotation.
     *
     * @param constraintAnnotation the constraint annotation used for validation
     */
    @Override
    public void initialize(Numeric constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * Determines if the given value is valid according to the Numeric constraint.
     *
     * @param value                         the value to be validated
     * @param constraintValidatorContext    the constraint validator context
     * @return true if the value is valid, false otherwise
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        return value.toString().matches("\\d+");
    }
}
