package com.salesianostriana.FleetManager.dto;

import com.salesianostriana.FleetManager.model.Estado;

import java.util.List;

public record VehiculoSummaryDto(
        Long id,
        String matricula,
        String modelo,
        Estado estado,
        List<MantenimientoSimpleDto> mantenimientoSimpleDtoList
) {

    public record MantenimientoSimpleDto(
            Long id,
            String tipo
    ){


    }
}
