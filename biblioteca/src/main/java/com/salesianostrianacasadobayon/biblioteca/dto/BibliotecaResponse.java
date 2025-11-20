package com.salesianostrianacasadobayon.biblioteca.dto;

import com.salesianostrianacasadobayon.biblioteca.model.Biblioteca;

public record BibliotecaResponse(
        Long id,
        String nombreCiudad,
        String nombreBiblioteca,
        String anoFundacion,
        int numeroAproxLibros,
        String descripcion,
        String urlBiblioteca

) {

    public static BibliotecaResponse of (Biblioteca biblioteca){

        return new BibliotecaResponse(
                biblioteca.getId(),
                biblioteca.getNombreCiudad(),
                biblioteca.getNombreBiblioteca(),
                biblioteca.getAnoFundacion().toString(),
                biblioteca.getNumeroAproxLibros(),
                biblioteca.getDescripcion(),
                biblioteca.getUrlBiblioteca()
        );
    }


    /*
    private Integer id;
     private String nombreCiudad;
    private String nombreBiblioteca;
    private LocalDate anoFundacion;
    private int numeroAproxLibros;
    private String descripcion;
    private String urlBiblioteca;
    * */
}
