package com.casadobayonantoniojesus.edutrack.service;

import com.casadobayonantoniojesus.edutrack.model.Curso;
import org.springframework.data.jpa.domain.PredicateSpecification;

public interface FiltradoCursos {

    public static PredicateSpecification<Curso> filtrarNivel(String nivel) {
        return (from, criteriaBuilder) -> (nivel == null)
                ? null
                : criteriaBuilder.equal(from.get("nivel"), nivel);
    }

    public static PredicateSpecification<Curso> filtrarActivo(Boolean activo) {
        return (from, criteriaBuilder) -> (activo == null)
                ? null
                : criteriaBuilder.equal(from.get("activo"), activo);
    }

    public static PredicateSpecification<Curso> filtrarPorNombre(String nombre) {
        return (from, builder) -> (nombre == null)
                ? null
                : builder.like(
                builder.lower(from.get("nombre")),
                "%" + nombre.toLowerCase() + "%"
        );
    }

}
