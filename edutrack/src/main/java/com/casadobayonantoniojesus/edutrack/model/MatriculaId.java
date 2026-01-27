package com.casadobayonantoniojesus.edutrack.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MatriculaId implements Serializable {

    private Long alumnoId;

    private Long cursoId;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        MatriculaId that = (MatriculaId) o;
        return alumnoId != null && Objects.equals(alumnoId, that.alumnoId)
                && cursoId != null && Objects.equals(cursoId, that.cursoId);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(alumnoId, cursoId);
    }
}
