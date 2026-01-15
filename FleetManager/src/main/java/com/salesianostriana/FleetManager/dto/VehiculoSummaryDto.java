package com.salesianostriana.FleetManager.dto;

import com.salesianostriana.FleetManager.model.Estado;
import com.salesianostriana.FleetManager.model.Vehiculo;

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
    public record ConductorSimpleDto(Long id, String nombre){}
    public static VehiculoSummaryDto of (Vehiculo vehiculo){
        return new VehiculoSummaryDto(
                vehiculo.getId(),
                vehiculo.getMatricula(),
                vehiculo.getModelo(),
                vehiculo.getEstado(),
                new ConductorSimpleDto()
        )
    }
}
