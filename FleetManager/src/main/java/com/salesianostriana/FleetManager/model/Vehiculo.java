package com.salesianostriana.FleetManager.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return getId() != null && Objects.equals(getId(), vehiculo.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
