package com.salesianostrianaejemplos.asociaciones.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabilidadEspecial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String tipo;

    private Integer costeMana;

    @ManyToOne
    @JoinColumn(name = "personaje_id")
    @Builder.Default
    private Personaje personaje;

}
