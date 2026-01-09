package com.salesianostriana.tribici.service;

import com.salesianostriana.tribici.model.Estacion;
import com.salesianostriana.tribici.repository.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstacionService {

    private final EstacionRepository estacionRepository;


    public List<Estacion> findAll() {
        List<Estacion> listaEstaciones = estacionRepository.findAll();
        if(listaEstaciones.isEmpty()){
            throw new RuntimeException("No hay estaciones disponibles");
        }
        return listaEstaciones;
    }

    public Estacion findById(Long id ){

        return estacionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se ha encontrado estacion con esta id"+id));
    }

    public Estacion crear ( Estacion estacion){
        if(!StringUtils.hasText(estacion.getNombre())){
            throw new RuntimeException("El nombre no puede estar vacio");
        }
        return estacionRepository.save(estacion);
    }
  }
