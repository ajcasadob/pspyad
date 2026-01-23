package com.salesianostriana.viviendafilter.service;

import com.salesianostriana.viviendafilter.model.EstadoVivienda;
import com.salesianostriana.viviendafilter.model.TipoVivienda;
import com.salesianostriana.viviendafilter.model.Vivienda;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.PredicateSpecification;

public interface ViviendaFilter {

    public static class Spec{
     static PredicateSpecification<Vivienda> filtrarCiduad(String ciudad){
        return ((from, builder) -> (ciudad == null)? null:
        builder.like(builder.lower(from.get("ciudad")),"%" + ciudad.toLowerCase()+ "%");
    }

     static PredicateSpecification<Vivienda> filtrarProvincia ( String provincia){
       return (from, builder)-> ( provincia == null) ? null:
               builder.equal(builder.lower(from.get("provincia")),provincia.toLowerCase());
    }
     static PredicateSpecification<Vivienda> precioMin (Integer precioMin){
        return (from, builder) -> (precioMin == null) ? null:
                builder.greaterThanOrEqualTo(from.get("precio"),precioMin);
    }

     static PredicateSpecification<Vivienda> precioMax (Integer precioMax){
        return  (from, builder) -> (precioMax == null) ? null:
                builder.lessThanOrEqualTo(from.get("precio"),precioMax);
    }
    static PredicateSpecification<Vivienda> metrosMin (Integer mentrosMin){
        return (from, builder)-> (mentrosMin == null) ? null:
                builder.greaterThanOrEqualTo(from.get("metrosCuadrados"),mentrosMin);
    }

    static PredicateSpecification<Vivienda> metrosMax (Integer metrosMax){
        return ( from, builder)-> (metrosMax == null ) ? null:
                builder.lessThanOrEqualTo(from.get("metrosCuadrados"),metrosMax);
    }
    static PredicateSpecification<Vivienda> habitacionesMin(Integer habitacionesMin){
        return ( from, builder)-> (habitacionesMin == null) ? null:
                builder.greaterThanOrEqualTo(from.get("habitaciones"),habitacionesMin);
    }
    static PredicateSpecification<Vivienda> banosMin (Integer banosMin){
        return (from, builder)-> (banosMin == null) ? null:
                builder.greaterThanOrEqualTo(from.get("banos"),banosMin);
    }

    static PredicateSpecification<Vivienda> filtrarTipoVivienda (TipoVivienda tipoVivienda){
        return (from, builder) -> (tipoVivienda == null) ? null:
                builder.equal(from.get("tipo"),tipoVivienda);
    }
    static PredicateSpecification<Vivienda> filtrarPorEstado(EstadoVivienda estadoVivienda){
        return (from, builder) ->(estadoVivienda == null) ? null:
        builder.equal(from.get("estado"),estadoVivienda);
    }

    static PredicateSpecification<Vivienda> filtrarPorAscensor(){
         return (from, builder)->
                 builder.isTrue(from.get("ascensor"));

    }

    }
}
