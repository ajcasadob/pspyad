package com.casadobayonantoniojesus.edutrack.dto;

import com.casadobayonantoniojesus.edutrack.model.Estado;

public record CreateMatriculaRequest(

        Long alumnoId,
        Long cursoId,
        Estado estado
) {
}
