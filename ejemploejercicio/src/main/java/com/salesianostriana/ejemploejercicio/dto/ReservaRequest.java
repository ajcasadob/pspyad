package com.salesianostriana.ejemploejercicio.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaRequest(
        Long salaId,
        Long usuarioId,
        LocalDate fecha,
        LocalTime horaInicio,
        LocalTime horaFin
) {

}
