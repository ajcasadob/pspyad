package com.salesianostriana.FleetManager.controller;

import com.salesianostriana.FleetManager.model.Vehiculo;
import com.salesianostriana.FleetManager.repository.AsignacionRepository;
import com.salesianostriana.FleetManager.service.AsignacionService;
import com.salesianostriana.FleetManager.service.ConductorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConductorController {

    private final AsignacionService asignacionService;


    @GetMapping("conductores/{id}/vehiculo-activo")
    public

}
