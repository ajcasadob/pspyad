package com.salesianostriana.viviendafilter.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



public class MetrosFueraRangoValidador implements ConstraintValidator<MetrosFueraRango, Double> {

    double metrosMax;

    @Override
    public void initialize(MetrosFueraRango constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        metrosMax= constraintAnnotation.metrosMax();
    }

    @Override
    public boolean isValid(Double metros, ConstraintValidatorContext constraintValidatorContext) {
        return metros !=null && metros<metrosMax;
    }
}
