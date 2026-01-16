package com.salesianostriana.bookclub.dto;

import com.salesianostriana.bookclub.model.Estado;
import com.salesianostriana.bookclub.model.Libro;
import com.salesianostriana.bookclub.model.Usuario;

import java.time.LocalDate;

public record CreatePrestamoRequest(
        Long id,
        LocalDate fechaInicio,
        Estado estado,
        Usuario usuario,
        Libro libro
) {
}
