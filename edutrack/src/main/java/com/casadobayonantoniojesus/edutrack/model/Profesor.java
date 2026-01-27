package com.casadobayonantoniojesus.edutrack.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Profesor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String especialidad;


    @Builder.Default
    @OneToMany(mappedBy = "profesor",fetch = FetchType.LAZY)
    private List<Curso> cursoList = new ArrayList<>();

    public void addCurso(Curso curso) {
        this.cursoList.add(curso);
        curso.setProfesor(this);
    }

    public void removeCurso(Curso curso) {
        this.cursoList.remove(curso);
        curso.setProfesor(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Profesor profesor = (Profesor) o;
        return getId() != null && Objects.equals(getId(), profesor.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
