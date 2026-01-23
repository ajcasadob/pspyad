package com.salesianostriana.viviendafilter.service;

import com.salesianostriana.viviendafilter.repository.ViviendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViviendaService {

    private final ViviendaRepository viviendaRepository;

}
