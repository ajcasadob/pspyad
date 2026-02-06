package com.salesianostrianacasadobayon.biblioteca.dto;

import com.salesianostrianacasadobayon.biblioteca.model.Biblioteca;
import com.salesianostrianacasadobayon.biblioteca.validation.UniqueNombreBiblioteca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CrearBibliotecaCmd(
        @NotBlank(message = "Pon algo hijo")
        String nombreCiudad,
        @UniqueNombreBiblioteca(message = "{crearBiblioteca.nombreBiblioteca.unique}")
        String nombreBiblioteca,
        @NotBlank
        String anoFundacion,
        @NotNull
        int numeroAproxLibros,
        @NotBlank
        String descripcion,
        @NotBlank
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
