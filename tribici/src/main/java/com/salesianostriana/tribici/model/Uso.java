package com.salesianostriana.tribici.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Uso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private double coste;

    @ManyToOne
    private Bicicleta bicicleta;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Estacion estacion;
}
