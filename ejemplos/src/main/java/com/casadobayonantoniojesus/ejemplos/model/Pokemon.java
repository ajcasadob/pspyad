package com.casadobayonantoniojesus.ejemplos.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pokemon", nullable = false, unique = true)
    private Long id;


    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "pokemon",cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Estadistica> estadisticas = new ArrayList<>();

}
