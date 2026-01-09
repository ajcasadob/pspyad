package com.salesianostriana.tribici.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
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
    @Builder.Default
    private List<Bicicleta> bicicletaList = new ArrayList<>();

    @OneToMany
    @Builder.Default
    private List<Uso> uso = new ArrayList<>();

    //Metodos de utilidad

    public void addBicicleta (Bicicleta bicicleta){
        bicicletaList.add(bicicleta);
        bicicleta.setEstacion(this);
    }

    public void removeBicicleta(Bicicleta bicicleta){
        bicicletaList.remove(bicicleta);
        bicicleta.setEstacion(null);
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Estacion estacion = (Estacion) o;
        return getId() != null && Objects.equals(getId(), estacion.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }


}
