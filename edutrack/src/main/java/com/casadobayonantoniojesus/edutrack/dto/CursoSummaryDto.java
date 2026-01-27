package com.casadobayonantoniojesus.edutrack.dto;

public record CursoSummaryDto(
        String nombre,
        String nivel,
        Integer plazaMaxima,
        Boolean activo,
        String nombreProfesor
) {
}
