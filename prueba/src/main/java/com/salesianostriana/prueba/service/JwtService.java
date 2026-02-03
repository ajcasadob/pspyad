package com.salesianostriana.prueba.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.WeakKeyException;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JwtService {

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    @PostConstruct
    private void init() {
        try {
            // Validar que la clave Base64 es válida
            byte[] keyBytes = Decoders.BASE64.decode(secretKey);
            
            // Verificar que tenga al menos 256 bits (32 bytes)
            if (keyBytes.length < 32) {
                throw new IllegalStateException(
                    String.format("La clave JWT debe tener al menos 256 bits (32 bytes). Tamaño actual: %d bytes", 
                    keyBytes.length)
                );
            }
            
            log.info("JwtService inicializado correctamente. Clave secreta validada ({} bytes)", keyBytes.length);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("La clave JWT no es un Base64 válido", e);
        }
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> extraClaims = new HashMap<>();
        
        // Incluir roles en los claims del token
        var roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        extraClaims.put("roles", roles);
        
        return generateToken(extraClaims, userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        try {
            return Jwts.builder()
                    .claims(extraClaims)
                    .subject(userDetails.getUsername())
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
                    .signWith(getSignInKey())
                    .compact();
        } catch (WeakKeyException e) {
            throw new RuntimeException("La clave secreta es demasiado débil. Debe tener al menos 256 bits.", e);
        }
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            final String username = extractUsername(token);
            return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
        } catch (JwtException e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(getSignInKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (ExpiredJwtException e) {
            throw new JwtException("El token JWT ha expirado", e);
        } catch (io.jsonwebtoken.security.SignatureException e) {
            throw new JwtException("La firma del token JWT es inválida", e);
        } catch (JwtException e) {
            throw new JwtException("Token JWT inválido: " + e.getMessage(), e);
        }
    }

    private SecretKey getSignInKey() {
        // Usando Decoders de JJWT en lugar de java.util.Base64
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
