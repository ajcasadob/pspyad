package com.salesianostriana.ejemploejercicio.controller;

import com.salesianostriana.ejemploejercicio.dto.ParamDTO;
import com.salesianostriana.ejemploejercicio.dto.SalaResponse;
import com.salesianostriana.ejemploejercicio.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequiredArgsConstructor
public class SalaController {


    private final SalaService service;

    @GetMapping("")
    public ResponseEntity<Page<SalaResponse>> filtrado(@PageableDefault (
            page = 0,
            size = 10,
            sort = "nombre",
            direction = Sort.Direction.DESC) Pageable pageable,
                                                       @RequestParam (required = false) String nombre,
                                                       @RequestParam (required = false) Integer planta,
                                                       @RequestParam(required = false) Integer capacidadMin,
                                                       @RequestParam(required = false) Integer capacidadMax,
                                                       @RequestParam(required = false) Boolean disponible,
                                                       @RequestParam(required = false)LocalDate fecha,
                                                       @RequestParam(required = false) LocalDateTime horaInicio,
                                                       @RequestParam(required = false) LocalDateTime horaFin

                                                       )

    {

        ParamDTO filtrado = new ParamDTO(
                nombre,planta,capacidadMin,capacidadMax,disponible,fecha,horaInicio,horaFin
        );
        return ResponseEntity.ok(service.filtrado(pageable,filtrado).map(SalaResponse::of));

    }

}
