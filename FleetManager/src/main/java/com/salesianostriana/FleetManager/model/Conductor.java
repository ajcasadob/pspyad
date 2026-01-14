package com.salesianostriana.FleetManager.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Conductor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String email;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "conductor", fetch = FetchType.LAZY)
    private List<Asignacion> asignaciones = new ArrayList<>();

    public void addAsignacion (Asignacion asignacion){
        this.asignaciones.add(asignacion);
        asignacion.setConductor(this);
    }
}
