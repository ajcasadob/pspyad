package com.salesianostriana.viviendafilter.controller;

import com.salesianostriana.viviendafilter.service.ViviendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/viviendas")
public class ViviendaController {

    private final ViviendaService viviendaService;
}
