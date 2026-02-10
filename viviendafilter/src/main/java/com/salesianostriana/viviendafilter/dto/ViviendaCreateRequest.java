package com.salesianostriana.viviendafilter.dto;

import com.salesianostriana.viviendafilter.model.EstadoVivienda;
import com.salesianostriana.viviendafilter.model.TipoVivienda;
import com.salesianostriana.viviendafilter.validation.MetrosFueraRango;
import com.salesianostriana.viviendafilter.validation.PrecioFueraRango;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ViviendaCreateRequest(
        @NotBlank @Size(max = 120)
        String titulo,
        @Size(max = 2000)
        String descripcion,
        @NotBlank @Size(max = 80)
        String ciudad,
        @NotBlank @Size(max = 80)
        String provincia,
        @NotNull @Min(0) @PrecioFueraRango(precioMax = 1_000_000)
        Double precio,
        @NotNull @Min(1) @MetrosFueraRango(metrosMax = 1_000)
        Double metrosCuadrados,
        @NotNull @Min(0)
        Integer habitaciones,
        @NotNull @Min(0)
        Integer banos,
        @NotNull
        TipoVivienda tipo,
        @NotNull
        EstadoVivienda estado,
        @NotNull
        Boolean ascensor,
        @NotNull
        Boolean terraza,
        @NotNull
        Boolean garaje,
        @NotNull
        Boolean disponible
) {
}
