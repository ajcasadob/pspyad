package com.casadobayonantoniojesus.edutrack.service;

import com.casadobayonantoniojesus.edutrack.dto.CursoDetailDto;
import com.casadobayonantoniojesus.edutrack.model.Curso;
import com.casadobayonantoniojesus.edutrack.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public Page<Curso> filtrado (Pageable pageable, CursoDetailDto curso){

        return cursoRepository.findBy(
                PredicateSpecification.allOf(
                        FiltradoCursos.filtrarNivel(curso.nivel()),
                        FiltradoCursos.filtrarPorNombre(curso.nombre()),
                        FiltradoCursos.filtrarActivo(curso.activo())
                ),q->q.page(pageable)
        );
    }
}
