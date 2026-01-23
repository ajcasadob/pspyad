package com.salesianostriana.viviendafilter.dto;

import com.salesianostriana.viviendafilter.model.EstadoVivienda;
import com.salesianostriana.viviendafilter.model.TipoVivienda;

public record FiltradoDto(
        String ciudad,
        String provincia,
        Double precioMin,
        Double precioMax,
        Double metrosMin,
        Double metrosMax,
        Integer habMin,
        Integer banosMin,
        TipoVivienda tipo,
        EstadoVivienda estado,
        Boolean ascensor,
        Boolean terraza,
        Boolean garaje,
        Boolean disponible

) {
}
