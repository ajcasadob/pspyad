package com.casadobayonantoniojesus.edutrack.dto;

public record CursoDetailDto(
        String nivel,
        Boolean activo,
        String nombre,
        Integer plazasMaximas
) {
}
