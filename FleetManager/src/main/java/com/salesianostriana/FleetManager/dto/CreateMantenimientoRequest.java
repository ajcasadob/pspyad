package com.salesianostriana.FleetManager.dto;

import java.time.LocalDate;

public record CreateMantenimientoRequest(
        String tipo,
        LocalDate fecha,
        double kmEnRevision,
        Long vehiculoId,
        Long tallerId
) {

}
