package com.salesianostriana.FleetManager.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Vehiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String matricula;

    private String modelo;

    private double KmActuales;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "vehiculo",fetch = FetchType.LAZY)
    private List<Asignacion> asignaciones = new ArrayList<>();


    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "vehiculo",fetch = FetchType.LAZY)
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

    public void addAsignacion ( Asignacion asignacion){
        this.asignaciones.add(asignacion);
        asignacion.setVehiculo(this);
    }

    public void addMantenimiento ( Mantenimiento mantenimiento){
        this.mantenimientos.add(mantenimiento);
        mantenimiento.setVehiculo(this);
    }

}
