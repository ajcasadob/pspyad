package com.salesianostrianacasadobayon.biblioteca.error;

public class LibraryNotFoundException extends RuntimeException {



    public LibraryNotFoundException() {
        super("No se han encontrado bibliotecas.");
    }

    public LibraryNotFoundException(String message) {

        super(message);
    }

    public LibraryNotFoundException (Long id) {
        super("No se ha encontrado la biblioteca con ID: " + id);
    }
}
