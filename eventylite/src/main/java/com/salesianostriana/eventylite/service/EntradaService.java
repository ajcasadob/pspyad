package com.salesianostriana.eventylite.service;

import com.salesianostriana.eventylite.dto.CreateEntradaRequest;
import com.salesianostriana.eventylite.model.Asistente;
import com.salesianostriana.eventylite.model.Entrada;
import com.salesianostriana.eventylite.model.Estado;
import com.salesianostriana.eventylite.model.Evento;
import com.salesianostriana.eventylite.repository.AsistenteRepository;
import com.salesianostriana.eventylite.repository.EntradaRepository;
import com.salesianostriana.eventylite.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EntradaService {


    private final EntradaRepository entradaRepository;
    private final EventoRepository eventoRepository;
    private final AsistenteRepository asistenteRepository;


    public Entrada comprarEntradas (CreateEntradaRequest createEntradaRequest ){

        Evento ev = eventoRepository.findById(createEntradaRequest.eventoId())
                .orElseThrow(()-> new EntityNotFoundException("El evento con id %d no existe".formatted(createEntradaRequest.eventoId())));

        Asistente as = asistenteRepository.findById(createEntradaRequest.asistenteId())
                .orElseThrow(()-> new EntityNotFoundException("El asistente con id %d no existe".formatted(createEntradaRequest.asistenteId())));

        if(ev.getEntradasVendidas() > ev.getAforoMaximo())

            throw  new IllegalArgumentException("Aforo completo");

        Entrada entrada = Entrada.builder()
                .fechaCompra(LocalDate.now())
                .estado(Estado.ACTIVA)
                .evento(ev)
                .asistente(as)
                .build();

        ev.setEntradasVendidas(ev.getEntradasVendidas()+1);
        ev.addEntrada(entrada);
        as.addEntrada(entrada);
        return entradaRepository.save(entrada);

    }

    public Entrada cancelarEntradas ( Long entradaId){

        Entrada en = entradaRepository.findById(entradaId)
                .orElseThrow(()-> new EntityNotFoundException("Entrada no encontrada con id %d".formatted(entradaId)));

        Evento evento = en.getEvento();

        en.setEstado(Estado.CANCELADA);
        evento.setEntradasVendidas(evento.getEntradasVendidas()-1);
        return entradaRepository.save(en);


    }

    public Page<Entrada> mostrarInfo (Long eventoId, Pageable pageable){

        return entradaRepository.findByEvento_id(eventoId,pageable);
    }






}
