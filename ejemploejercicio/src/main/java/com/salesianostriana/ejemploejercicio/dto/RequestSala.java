package com.salesianostriana.ejemploejercicio.dto;

import com.salesianostriana.ejemploejercicio.model.Reserva;

public record RequestSala(
        Long id,
        String ciudad,
        Integer planta,
        Integer capacidad,
        Boolean disponibilidad,
        Reserva reserva
) {
}
