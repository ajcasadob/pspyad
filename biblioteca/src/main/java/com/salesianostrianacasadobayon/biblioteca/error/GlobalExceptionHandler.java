package com.salesianostrianacasadobayon.biblioteca.error;

import com.salesianostrianacasadobayon.biblioteca.dto.ApiValidationSubError;
import org.springframework.http.*;
import org.springframework.objenesis.ObjenesisException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LibraryNotFoundException.class)
    public ProblemDetail handleLibraryNotFound(LibraryNotFoundException ex) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(

                HttpStatus.NOT_FOUND,

                ex.getMessage()
        );

        problemDetail.setTitle("Biblioteca no encontrada");

        problemDetail.setType(URI.create("http://dam.salesianos-triana.com/library-not-found"));

        return problemDetail;
    }


    @ExceptionHandler(InvalidLibraryDataException.class)
    public ProblemDetail handleInvalidLibraryData(InvalidLibraryDataException ex) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(

                HttpStatus.BAD_REQUEST,

                ex.getMessage()
        );

        problemDetail.setTitle("Datos de biblioteca inválidos");

        problemDetail.setType(URI.create("http://dam.salesianos-triana.com/invalid-library-data"));

        return problemDetail;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
      ProblemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());

      List<ApiValidationSubError> subErrors =
              ex.getAllErrors().stream()
                      .map(ApiValidationSubError::from)
                      .toList();

      result.setProperty("Parametros invalidos",subErrors);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body(result);

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
