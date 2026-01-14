package com.salesianostriana.FleetManager.dto;

import java.time.LocalDate;

public record CreateAsignacionRequest(
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Long vehiculoId,
        Long conductorId
) {
}
