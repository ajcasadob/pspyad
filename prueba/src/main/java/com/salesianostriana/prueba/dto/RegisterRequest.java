package com.salesianostriana.prueba.dto;

public record RegisterRequest(
        String username,
        String email,
        String password
) {
}
