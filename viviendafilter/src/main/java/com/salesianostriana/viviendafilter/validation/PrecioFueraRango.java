package com.salesianostriana.viviendafilter.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PrecioFueraRangoValidator.class)
public @interface PrecioFueraRango {

    String message ( ) default "El precio debe de estar en un rango permitido";

    Class <?> [] groups ( ) default  {};

    Class <? extends Payload> [] payload() default {};

    double precioMax();

}
