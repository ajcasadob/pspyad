package com.salesianostrianacasadobayon.biblioteca.dto;

import com.salesianostrianacasadobayon.biblioteca.model.Biblioteca;

import java.time.LocalDate;

public record CrearBibliotecaCmd(
        String nombreCiudad,
        String nombreBiblioteca,
        String anoFundacion,
        int numeroAproxLibros,
        String descripcion,
        String urlBiblioteca
) {


    public Biblioteca toEntity() {
        return Biblioteca.builder()
                .nombreCiudad(this.nombreCiudad)
                .nombreBiblioteca(this.nombreBiblioteca)
                .anoFundacion(LocalDate.parse(this.anoFundacion))
                .numeroAproxLibros(this.numeroAproxLibros)
                .descripcion(this.descripcion)
                .urlBiblioteca(this.urlBiblioteca)
                .build();
    }


    /*
    private String nombreCiudad;
    private String nombreBiblioteca;
    private LocalDate anoFundacion;
    private int numeroAproxLibros;
    private String descripcion;
    private String urlBiblioteca;
    */


}
