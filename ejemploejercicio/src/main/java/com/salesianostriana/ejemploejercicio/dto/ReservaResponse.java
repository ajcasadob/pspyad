package com.salesianostriana.ejemploejercicio.dto;

import com.salesianostriana.ejemploejercicio.model.EstadoReserva;
import com.salesianostriana.ejemploejercicio.model.Reserva;
import com.salesianostriana.ejemploejercicio.model.Sala;
import com.salesianostriana.ejemploejercicio.model.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaResponse(
        Long id,
        Sala salaNombre,
        Usuario usuarioNombre,
        LocalDate fecha,
        LocalTime horaInicio,
        LocalTime horaFin,
        EstadoReserva estado

) {

    public static ReservaResponse of (Reserva r){

        return new ReservaResponse(
                r.getId(),
                r.getSala(),
                r.getUsuario(),
                r.getFecha(),
                r.getFechaInicio(),
                r.getHoraFin(),
                r.getEstado()
        );

    }
}
