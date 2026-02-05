package com.salesianostriana.viviendafilter.service;

import com.salesianostriana.viviendafilter.dto.FiltradoDto;
import com.salesianostriana.viviendafilter.model.Vivienda;
import com.salesianostriana.viviendafilter.repository.ViviendaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ViviendaService {

    private final ViviendaRepository viviendaRepository;

    @Transactional(readOnly = true)
    public Page<Vivienda> filtrado ( Pageable pageable, FiltradoDto filtro){
        return viviendaRepository.findBy(
                PredicateSpecification.allOf(
                        ViviendaFilter.filtrarCiduad(filtro.ciudad()),
                        ViviendaFilter.filtrarProvincia(filtro.provincia()),
                        ViviendaFilter.filtrarPorPrecicio(filtro.precioMin(),filtro.precioMax()),
                        ViviendaFilter.filtrarPorMetros(filtro.metrosMin(),filtro.metrosMax()),
                        ViviendaFilter.habitacionesMin(filtro.habMin()),
                        ViviendaFilter.banosMin(filtro.banosMin()),
                        ViviendaFilter.filtrarTipoVivienda(filtro.tipo()),
                        ViviendaFilter.filtrarPorEstado(filtro.estado()),
                        ViviendaFilter.filtrarPorAscensor(filtro.ascensor()),
                        ViviendaFilter.filtrarPorTerraza(filtro.terraza()),
                        ViviendaFilter.filtrarPorGaraje(filtro.garaje()),
                        ViviendaFilter.filtrarPorDisponibilidad(filtro.disponible())
                ), q ->q.page(pageable)
        );
    }
}
