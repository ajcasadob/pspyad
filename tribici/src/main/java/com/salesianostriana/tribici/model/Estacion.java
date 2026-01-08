package com.salesianostriana.tribici.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
public class Estacion {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numero;

    @Column(unique = true)
    private String nombre;

    private double coordenadas;

    private long capacidad;

    @OneToMany(mappedBy = "estacion")
    private List<Bicicleta> bicicletaList;
    @OneToMany
    @Builder.Default
    private List<Uso> uso = new ArrayList<>();



}
