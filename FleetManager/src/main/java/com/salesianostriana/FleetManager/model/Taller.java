package com.salesianostriana.FleetManager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Taller {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String nombre;

    private String ciudad;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "taller",fetch = FetchType.LAZY)
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

    public void addMantenimiento ( Mantenimiento mantenimiento){
        this.mantenimientos.add(mantenimiento);
        mantenimiento.setTaller(this);
    }
}
