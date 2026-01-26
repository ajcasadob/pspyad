package com.salesianostriana.ejemploejercicio.dto;

import com.salesianostriana.ejemploejercicio.model.Sala;

public record SalaResponse(
        String nombre,
        Integer planta,
        Integer capacidad,
        Boolean disponibilidad
) {

    public static SalaResponse of (Sala sala){

        return new SalaResponse(

                sala.getNombre(),
                sala.getPlanta(),
                sala.getCapacidad(),
                sala.getDisponible()
        );

    }
}
