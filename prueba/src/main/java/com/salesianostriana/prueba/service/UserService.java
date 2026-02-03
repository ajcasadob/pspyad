package com.salesianostriana.prueba.service;

import com.salesianostriana.prueba.dto.AuthResponse;
import com.salesianostriana.prueba.dto.UserResponse;
import com.salesianostriana.prueba.model.Role;
import com.salesianostriana.prueba.model.User;
import com.salesianostriana.prueba.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(Collections.singletonList(
                        new SimpleGrantedAuthority(user.getRole().getAuthority())
                ))
                .build();
    }

    public User createUser(String username, String email, String password) {
        // Validar que el usuario no exista
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("El username ya está en uso");
        }

        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("El email ya está en uso");
        }

        // Crear nuevo usuario
        User user = User.builder()
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();

        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }

    public AuthResponse buildAuthResponse(User user, String token) {
        return new AuthResponse(
                token,
                user.getUsername(),
                user.getRole().getRoleName(),
                "Operación exitosa"
        );
    }

    // Mapper: Entity to DTO
    public UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole().getRoleName()
        );
    }
}
