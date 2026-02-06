package com.salesianostrianacasadobayon.biblioteca.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueBibliotecaNameValidator.class)
@Documented
public @interface UniqueNombreBiblioteca {

    String message ( ) default "El nombre de la biblioteca no puede estar vacio";

    Class<?>[] groups() default {};

    Class<? extends Payload> [] payload() default {};


}
