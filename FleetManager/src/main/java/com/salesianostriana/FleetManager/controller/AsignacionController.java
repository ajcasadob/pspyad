package com.salesianostriana.FleetManager.controller;

import com.salesianostriana.FleetManager.service.AsignacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AsignacionController {

    private final AsignacionService asignacionService;


}
