package com.salesianostriana.FleetManager.controller;

import com.salesianostriana.FleetManager.dto.VehiculoSummaryDto;
import com.salesianostriana.FleetManager.model.Vehiculo;
import com.salesianostriana.FleetManager.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;


    @GetMapping("/vehiculos")
    public Page<VehiculoSummaryDto> obtenerVehiculos(@PageableDefault(page =0, size=20)Pageable pageable){

    }



}
