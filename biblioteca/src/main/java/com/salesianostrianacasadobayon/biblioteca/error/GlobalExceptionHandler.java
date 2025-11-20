package com.salesianostrianacasadobayon.biblioteca.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(LibraryNotFoundException.class)
    public ProblemDetail handleLibraryNotFound(LibraryNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );

        problemDetail.setTitle("Biblioteca no encontrada");
        problemDetail.setType(
                URI.create("http://dam.salesianos-triana.com/library-not-found")
        );

        return problemDetail;
    }


    @ExceptionHandler(InvalidLibraryDataException.class)
    public ProblemDetail handleInvalidLibraryData(InvalidLibraryDataException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );

        problemDetail.setTitle("Datos de biblioteca inválidos");
        problemDetail.setType(
                URI.create("http://dam.salesianos-triana.com/invalid-library-data")
        );

        return problemDetail;
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleBadLibrary(IllegalArgumentException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );

        return problemDetail;
    }
}
