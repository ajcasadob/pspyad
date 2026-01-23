package com.salesianostriana.viviendafilter.dto;

import com.salesianostriana.viviendafilter.model.EstadoVivienda;
import com.salesianostriana.viviendafilter.model.TipoVivienda;
import com.salesianostriana.viviendafilter.model.Vivienda;

import java.time.LocalDate;

public record ViviendaResponse(
        Long id,
        String titulo,
        String ciudad,
        String provincia,
        Integer precio,
        Integer metrosCuadrados,
        Integer habitaciones,
        Integer banos,
        TipoVivienda tipoVivienda,
        EstadoVivienda estadoVivienda,
        Boolean disponible,
        LocalDate fechaPublicacion
) {

    public ViviendaResponse of (Vivienda v){
        return new ViviendaResponse(
                v.getId(),
                v.getTitulo(),
                v.getCiudad(),
                v.getProvincia(),
                v.getPrecio(),
                v.getMetrosCuadrados(),
                v.getHabitaciones(),
                v.getBanos(),
                v.getTipoVivienda(),
                v.getEstadoVivienda(),
                v.getDisponible(),
                v.getFechaPublicacion()


        );
    }
}
