package com.casadobayonantoniojesus.ejemplos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estadistica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estadistica", nullable = false, unique = true)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;


    @Column(name = "valor",nullable = false)
    private Integer valor;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pokemon", nullable = false)
    private Pokemon pokemon;
}
