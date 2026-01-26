package com.salesianostriana.ejemploejercicio.service;

import com.salesianostriana.ejemploejercicio.model.Sala;
import org.springframework.data.jpa.domain.PredicateSpecification;

import java.time.LocalDate;
import java.time.LocalDateTime;


public interface SalaSpec {

    public static PredicateSpecification<Sala> filtrarPlanta (Integer planta){
        return (from, criteriaBuilder) -> (planta == null) ?

                criteriaBuilder.and() : criteriaBuilder.equal(from.get("planta"),planta);
    }

    public static PredicateSpecification<Sala> filtrarCapacidad (Integer capacidadMin, Integer capacidadMax){


            Integer capacidad_Min = (capacidadMin== null) ? 0 :capacidadMin;
            Integer capacidad_Max = (capacidadMax == null) ? 1000 :capacidadMax;
            return ((from, criteriaBuilder) ->
                    criteriaBuilder.between(from.get("capacidad"),capacidad_Min,capacidad_Max));

    }

    public static PredicateSpecification<Sala> filtarPorNombre ( String nombre){

        return ((from, criteriaBuilder) -> (nombre== null)?
                criteriaBuilder.and() :
                criteriaBuilder.like(from.get("nombre"),"%" + nombre+ "%"));

    }

    public static PredicateSpecification<Sala> filtrarPorDisponibilidad (Boolean disponibilidad ){

        return ((from, criteriaBuilder) -> (disponibilidad== null) ?
                criteriaBuilder.and():
                criteriaBuilder.isTrue(from.get("disponibilidad")));
    }

    public static PredicateSpecification<Sala> filtrarPorFecha (LocalDate fecha){
        return ((from, criteriaBuilder) -> (fecha== null) ?
                criteriaBuilder.and():
                criteriaBuilder.equal(from.join("reserva").get("fecha"),fecha));
    }

    public static PredicateSpecification<Sala> filtrarHoraInicio(LocalDateTime horaInicio, LocalDateTime horaFin) {
        return (from, criteriaBuilder) -> (horaInicio == null || horaFin == null) ?
                criteriaBuilder.and() :
                criteriaBuilder.between(from.join("reserva").get("horaInicio"), horaInicio, horaFin);
    }



}
