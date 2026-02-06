package com.salesianostriana.viviendafilter.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MetrosFueraRangoValidador.class)
@Documented
public @interface MetrosFueraRango {

    String message () default  "Metros cuadrado fuera de rango";

    Class <?> [] groups () default {};

    Class <? extends Payload> [] payload () default {};

    double metrosMax();

}
