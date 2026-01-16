package com.salesianostriana.bookclub.dto;

import com.salesianostriana.bookclub.model.Estado;
import com.salesianostriana.bookclub.model.Libro;

import java.time.LocalDate;

public record PrestamoDto(
        LocalDate fechaInicio,
        Estado estado,
        Libro libro
) {
}
