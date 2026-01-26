package com.salesianostriana.ejemploejercicio.service;

import com.salesianostriana.ejemploejercicio.dto.ParamDTO;
import com.salesianostriana.ejemploejercicio.dto.RequestSala;
import com.salesianostriana.ejemploejercicio.model.Reserva;
import com.salesianostriana.ejemploejercicio.model.Sala;
import com.salesianostriana.ejemploejercicio.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SalaService {

    private final SalaRepository salaRepository;



    @Transactional(readOnly = true)
    public Page<Sala> filtrado (Pageable pageable, ParamDTO param){

       return  salaRepository.findBy(
                PredicateSpecification.allOf(
                        SalaSpec.filtarPorNombre(param.nombre()),
                        SalaSpec.filtrarPlanta(param.planta()),
                        SalaSpec.filtrarCapacidad(param.capacidadMin(),param.capacidadMax()),
                        SalaSpec.filtrarPorDisponibilidad(param.disponibilidad()),
                        SalaSpec.filtrarPorFecha(param.fecha()),
                        SalaSpec.filtrarHoraInicio(param.horaInicio(),param.horaFin())
                ),q ->q.page(pageable)
        );


    }








}
