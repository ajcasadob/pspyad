package com.salesianostriana.prueba.dto;

public record AuthResponse(
        String token,
        String username,
        String role,
        String mensaje
) {
}
