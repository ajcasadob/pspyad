package com.salesianostriana.prueba.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/protected")
public class ProtectedController {

    @GetMapping("/data")
    public ResponseEntity<Map<String, String>> protectedEndpoint() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok(Map.of(
                "mensaje", "¡Datos protegidos!",
                "descripcion", "Solo accesible con JWT válido",
                "usuario_autenticado", auth.getName()
        ));
    }

    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> userProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok(Map.of(
                "username", auth.getName(),
                "roles", auth.getAuthorities(),
                "mensaje", "Perfil de usuario protegido"
        ));
    }

    // Endpoint solo para ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<Map<String, String>> adminEndpoint() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok(Map.of(
                "mensaje", "¡Panel de administración!",
                "descripcion", "Solo accesible por usuarios ADMIN",
                "admin", auth.getName()
        ));
    }
}
