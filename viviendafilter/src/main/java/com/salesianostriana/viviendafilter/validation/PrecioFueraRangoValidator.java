package com.salesianostriana.viviendafilter.validation;

import com.salesianostriana.viviendafilter.repository.ViviendaRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class PrecioFueraRangoValidator implements ConstraintValidator<PrecioFueraRango,Double> {


    double precioMax;

    @Override
    public void initialize(PrecioFueraRango constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        precioMax = constraintAnnotation.precioMax();
    }

    @Override
    public boolean isValid(Double precio, ConstraintValidatorContext constraintValidatorContext) {
        return precio !=null && precio<precioMax;
    }
}
