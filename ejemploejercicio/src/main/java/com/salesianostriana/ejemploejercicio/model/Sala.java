package com.salesianostriana.ejemploejercicio.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Sala {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer planta;

    private Integer capacidad;

    private Boolean disponible;

    @Builder.Default
    @OneToMany(mappedBy = "sala",fetch = FetchType.LAZY)
    private List<Reserva > reservaList = new ArrayList<>();
}
