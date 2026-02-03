package com.salesianostriana.prueba.dto;

public record UserResponse(
        Long id,
        String username,
        String email,
        String role
) {
}
