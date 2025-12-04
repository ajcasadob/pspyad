package com.salesianostrianaejemplos.asociaciones.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Personaje {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String clase;

    private Integer nivel;

    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<HabilidadEspecial> habilidades = new ArrayList<>();



}
