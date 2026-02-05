package com.salesianostrianacasadobayon.biblioteca.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Biblioteca {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCiudad;
    private String nombreBiblioteca;
    private LocalDate anoFundacion;
    private int numeroAproxLibros;
    private String descripcion;
    private String urlBiblioteca;

}
