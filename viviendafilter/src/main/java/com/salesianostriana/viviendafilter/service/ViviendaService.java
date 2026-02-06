package com.salesianostriana.viviendafilter.service;

import com.salesianostriana.viviendafilter.dto.FiltradoDto;
import com.salesianostriana.viviendafilter.dto.ViviendaCreateRequest;
import com.salesianostriana.viviendafilter.model.Vivienda;
import com.salesianostriana.viviendafilter.repository.ViviendaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

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


    public Vivienda crearVivieda (ViviendaCreateRequest dto){

        Vivienda vivienda = Vivienda.builder()
                .titulo(dto.titulo())
                .descripcion(dto.descripcion())
                .ciudad(dto.ciudad())
                .provincia(dto.provincia())
                .precio(dto.precio())
                .metrosCuadrados(dto.metrosCuadrados())
                .habitaciones(dto.habitaciones())
                .banos(dto.banos())
                .tipoVivienda(dto.tipo())
                .estadoVivienda(dto.estado())
                .ascensor(dto.ascensor())
                .terraza(dto.terraza())
                .garaje(dto.garaje())
                .disponible(dto.disponible())
                .fechaPublicacion(LocalDate.now())
                .build();

        return viviendaRepository.save(vivienda);
    }



}
