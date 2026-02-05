package com.casadobayonantoniojesus.edutrack.dto;

import com.casadobayonantoniojesus.edutrack.model.Curso;

public record CursoResponse(
        String nombre,
        String nivel,
        Integer plazaMaximas,
        Boolean activo

) {

    public static CursoResponse of ( Curso c){
        return new CursoResponse(
                c.getNombre(),
                c.getNivel(),
                c.getPlazasMaximas(),
                c.getActivo()
        );
    }
}
