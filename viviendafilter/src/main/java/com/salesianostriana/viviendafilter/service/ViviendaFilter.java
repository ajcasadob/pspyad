package com.salesianostriana.viviendafilter.service;

import com.salesianostriana.viviendafilter.model.EstadoVivienda;
import com.salesianostriana.viviendafilter.model.TipoVivienda;
import com.salesianostriana.viviendafilter.model.Vivienda;

import org.springframework.data.jpa.domain.PredicateSpecification;

public interface ViviendaFilter {


    public static PredicateSpecification<Vivienda> filtrarCiduad(String ciudad){
        return ((from, builder) -> (ciudad == null)? null:
        builder.like(builder.lower(from.get("ciudad")),"%" + ciudad.toLowerCase()+ "%"));
    }

     public static PredicateSpecification<Vivienda> filtrarProvincia ( String provincia){
       return (from, builder)-> ( provincia == null) ? null:
               builder.equal(builder.lower(from.get("provincia")),provincia.toLowerCase());
    }
    public static PredicateSpecification<Vivienda> filtrarPorPrecicio(Double precioMin, Double precioMax){
        return (from, builder)->{
            Double precio_min = (precioMin == null) ? 0.0 : precioMin;
            Double precio_max = (precioMax == null) ? Double.POSITIVE_INFINITY: precioMax;

            return builder.between(from.get("precio"),precio_min,precio_max);
        };

    }
    public static PredicateSpecification<Vivienda> filtrarPorMetros ( Double metrosMin, Double metrosMax){
        return (from, builder)->{
            Double metros_min = (metrosMin == null) ? 0.0: metrosMin;
            Double metros_max = (metrosMax == null) ? Double.POSITIVE_INFINITY :metrosMax;

            return builder.between(from.get("metrosCuadrados"),metros_min,metros_max);
        };
    }
    public static PredicateSpecification<Vivienda> habitacionesMin(Integer habitacionesMin){
        return ( from, builder)-> (habitacionesMin == null) ? null:
                builder.greaterThanOrEqualTo(from.get("habitaciones"),habitacionesMin);
    }
    public static PredicateSpecification<Vivienda> banosMin (Integer banosMin){
        return (from, builder)-> (banosMin == null) ? null:
                builder.greaterThanOrEqualTo(from.get("banos"),banosMin);
    }

   public  static PredicateSpecification<Vivienda> filtrarTipoVivienda (TipoVivienda tipoVivienda){
        return (from, builder) -> (tipoVivienda == null) ? null:
                builder.equal(from.get("tipo"),tipoVivienda);
    }
   public  static PredicateSpecification<Vivienda> filtrarPorEstado(EstadoVivienda estadoVivienda){
        return (from, builder) ->(estadoVivienda == null) ? null:
        builder.equal(from.get("estado"),estadoVivienda);
    }

    public static PredicateSpecification<Vivienda> filtrarPorAscensor(Boolean ascensor){
         return (from, builder)-> (ascensor == null || !ascensor) ? null:
                 builder.isTrue(from.get("ascensor"));


    }

    public static PredicateSpecification<Vivienda> filtrarPorTerraza (Boolean terraza){
        return ( from, builder)-> (terraza == null || !terraza)? null:
                builder.isTrue(from.get("terraza"));
    }
    public static PredicateSpecification<Vivienda> filtrarPorGaraje(Boolean garaje){
        return (from,builder)-> (garaje == null || !garaje)? null:
                builder.isTrue(from.get("garaje"));
    }
    public static PredicateSpecification<Vivienda> filtrarPorDisponibilidad(Boolean disponible){
        return (from, builder) -> (disponible == null || !disponible)? null:
                builder.isTrue(from.get("disponible"));
    }

    }

