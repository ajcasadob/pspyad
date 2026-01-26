package com.salesianostriana.ejemploejercicio.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record ParamDTO(
        String nombre,
        Integer planta,
        Integer capacidadMin,
        Integer capacidadMax,
        Boolean disponibilidad,
        LocalDate fecha,
        LocalDateTime horaInicio,
        LocalDateTime horaFin

) {

}
