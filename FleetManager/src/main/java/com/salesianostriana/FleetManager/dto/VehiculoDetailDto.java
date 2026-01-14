package com.salesianostriana.FleetManager.dto;

import com.salesianostriana.FleetManager.model.Asignacion;
import com.salesianostriana.FleetManager.model.Estado;
import com.salesianostriana.FleetManager.model.Mantenimiento;

import java.time.LocalDate;
import java.util.List;

public record VehiculoDetailDto(
        Long id,
        String matricula,
        String modelo,
        double KmActuales,
        Estado estado,
        List<AsignacionSimpleDto> asignacionSimpleDtoList,
        List<MantenimientoSimpleDto> mantenimientoList
) {
    public record AsignacionSimpleDto(

            Long id,
            LocalDate fechaInicio,
            LocalDate fechaFin
    ){}

    public record MantenimientoSimpleDto(
            Long id,
            String tipo,
            double kmEnRevision

    ){}
}
