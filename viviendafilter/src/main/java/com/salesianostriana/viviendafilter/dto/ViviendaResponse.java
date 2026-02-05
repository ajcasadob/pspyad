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
        @NotBlank(message = "Es obligatorio")
        String titulo,
        @NotBlank
        String ciudad,
        @NotBlank
        String provincia,
        @NegativeOrZero
        Double precio,
        @NotBlank
        Double metrosCuadrados,
        @NotBlank
        Integer habitaciones,
        @NotBlank
        Integer banos,
        @Enumerated(EnumType.STRING)
        @NotBlank
        TipoVivienda tipoVivienda,
        @Enumerated(EnumType.STRING)
        @NotBlank
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
