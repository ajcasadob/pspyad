package com.salesianostriana.viviendafilter.dto;

import com.salesianostriana.viviendafilter.model.EstadoVivienda;
import com.salesianostriana.viviendafilter.model.TipoVivienda;
import com.salesianostriana.viviendafilter.model.Vivienda;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ViviendaResponse(

        Long id,
        String titulo,
        String ciudad,
        String provincia,
        Double precio,
        Double metrosCuadrados,
        Integer habitaciones,
        Integer banos,
        TipoVivienda tipoVivienda,
        EstadoVivienda estadoVivienda,
        Boolean disponible,
        LocalDate fechaPublicacion
) {

    public static ViviendaResponse of (Vivienda v){
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
