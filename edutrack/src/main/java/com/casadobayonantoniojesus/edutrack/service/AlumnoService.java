package com.casadobayonantoniojesus.edutrack.service;

import com.casadobayonantoniojesus.edutrack.repository.AlumnoRepository;
import com.casadobayonantoniojesus.edutrack.repository.CursoRepository;
import com.casadobayonantoniojesus.edutrack.repository.MatriculaRepository;
import com.casadobayonantoniojesus.edutrack.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;
    private final MatriculaRepository matriculaRepository;
    private final ProfesorRepository profesorRepository;





}
