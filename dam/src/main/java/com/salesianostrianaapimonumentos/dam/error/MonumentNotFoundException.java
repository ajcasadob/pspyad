package com.salesianostrianaapimonumentos.dam.error;

public class MonumentNotFoundException extends RuntimeException {
    public MonumentNotFoundException() {
        super("Monumento no encontrado");
    }
    public MonumentNotFoundException(Long id){super("El monumento con id" +id+ "no se encuentra");}
}
