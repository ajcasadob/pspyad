package com.salesianostriana.ejemploejercicio.service;

import com.salesianostriana.ejemploejercicio.dto.ReservaRequest;
import com.salesianostriana.ejemploejercicio.dto.ReservaResponse;
import com.salesianostriana.ejemploejercicio.model.EstadoReserva;
import com.salesianostriana.ejemploejercicio.model.Reserva;
import com.salesianostriana.ejemploejercicio.model.Sala;
import com.salesianostriana.ejemploejercicio.model.Usuario;
import com.salesianostriana.ejemploejercicio.repository.ReservaRepository;
import com.salesianostriana.ejemploejercicio.repository.SalaRepository;
import com.salesianostriana.ejemploejercicio.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;
    private final UsuarioRepository usuarioRepository;


    public Reserva crearReserva (ReservaRequest request){

        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));

        if(usuario.getBaneado()){
            throw new IllegalArgumentException("El usuario no puede realizar reservas");
        }

        Sala sala = salaRepository.findById(request.salaId())
                .orElseThrow(()-> new EntityNotFoundException("Sala no encontrada"));

        if(!request.horaFin().isAfter(request.horaInicio())){
            throw new IllegalArgumentException("La hora de fin debe ser posterior a la hora de inicio");
        }

        List<Reserva> reservaList = reservaRepository.findBySalaIdAndFechaAndEstadoAndHoraInicioLessThanAndHoraFinGreaterThan(
                request.salaId(),
                request.fecha(),
                EstadoReserva.CONFIRMADA,
                request.horaFin(),
                request.horaInicio()
        );

        if(!reservaList.isEmpty()){
            throw new IllegalArgumentException("La sala ya esta reservada");
        }

        Reserva reserva = Reserva.builder().
                sala(sala)
                .usuario(usuario)
                .fecha(request.fecha())
                .fechaInicio(request.horaInicio())
                .horaFin(request.horaFin())
                .estado(EstadoReserva.CONFIRMADA)
                .build();

        return reservaRepository.save(reserva);

    }





}
