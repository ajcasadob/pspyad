package com.salesianostriana.prueba.controller;

import com.salesianostriana.prueba.dto.AuthResponse;
import com.salesianostriana.prueba.dto.LoginRequest;
import com.salesianostriana.prueba.dto.RegisterRequest;
import com.salesianostriana.prueba.model.User;
import com.salesianostriana.prueba.service.JwtService;
import com.salesianostriana.prueba.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        // Crear usuario
        User user = userService.createUser(request.username(), request.email(), request.password());

        // Generar token
        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        String token = jwtService.generateToken(userDetails);

        // Construir respuesta
        AuthResponse response = userService.buildAuthResponse(user, token);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        // Autenticar
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        // Buscar usuario y generar token
        User user = userService.findByUsername(request.username());
        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        String token = jwtService.generateToken(userDetails);

        // Construir respuesta
        AuthResponse response = userService.buildAuthResponse(user, token);

        return ResponseEntity.ok(response);
    }
}
