package com.salesianostrianaapimonumentos.dam.service;

import com.salesianostrianaapimonumentos.dam.dto.MonumentoDTO;
import com.salesianostrianaapimonumentos.dam.error.MonumentNotFoundException;
import com.salesianostrianaapimonumentos.dam.model.Monumento;
import com.salesianostrianaapimonumentos.dam.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MonumentoService {

    private final MonumentoRepository monumentoRepository;


    public List<Monumento> findAll() {
        List<Monumento> listarMonumentos = monumentoRepository.findAll();
        if (listarMonumentos.isEmpty())
            throw new MonumentNotFoundException();
        return listarMonumentos;
    }

    public Monumento findById(Long id) {
        return monumentoRepository.findById(id)
                .orElseThrow(() -> new MonumentNotFoundException(id));
    }

    public Monumento save(MonumentoDTO m) {
        return monumentoRepository.save(
                Monumento.builder()
                        .nombreMonumento(m.monumentoNombre())
                        .nombreCiudad(m.nombreCiudad())
                        .nombrePais(m.nombrePais())
                        .nombreCodigo(m.nombreCodigo())
                        .latitud(m.latitud())
                        .longitud(m.longitud())
                        .descripcion(m.descripcion())
                        .urlFoto(m.fotoUrl())
                        .build()
        );
    }

    public Monumento edit(MonumentoDTO monumentoDTO, Long id) {

        Monumento monumento = Monumento.builder()
                .id(id)
                .nombreMonumento(monumentoDTO.monumentoNombre())
                .nombreCiudad(monumentoDTO.nombreCiudad())
                .nombrePais(monumentoDTO.nombrePais())
                .nombreCodigo(monumentoDTO.nombreCodigo())
                .latitud(monumentoDTO.latitud())
                .longitud(monumentoDTO.longitud())
                .descripcion(monumentoDTO.descripcion())
                .urlFoto(monumentoDTO.fotoUrl())

                .build();
        return monumentoRepository.save(monumento);
    }

    public void delete(Long id){
        monumentoRepository.deleteById(id);
    }







}
