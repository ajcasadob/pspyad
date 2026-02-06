package com.salesianostrianacasadobayon.biblioteca.validation;

import com.salesianostrianacasadobayon.biblioteca.repository.BibliotecaRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class UniqueBibliotecaNameValidator implements ConstraintValidator<UniqueNombreBiblioteca,String> {

    @Autowired
    private BibliotecaRepository repository;


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !repository.existsByNombreBiblioteca(s);
    }
}
