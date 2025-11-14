package com.salesianostrianaapimonumentos.dam.error;

public class MonumentNotFoundException extends RuntimeException {
  public MonumentNotFoundException(String message) {
    super(message);
  }
}
