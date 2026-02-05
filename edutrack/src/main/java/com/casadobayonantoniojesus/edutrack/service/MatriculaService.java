package com.casadobayonantoniojesus.edutrack.service;

import com.casadobayonantoniojesus.edutrack.dto.CreateMatriculaRequest;
import com.casadobayonantoniojesus.edutrack.model.*;
import com.casadobayonantoniojesus.edutrack.repository.AlumnoRepository;
import com.casadobayonantoniojesus.edutrack.repository.CursoRepository;
import com.casadobayonantoniojesus.edutrack.repository.MatriculaRepository;
import com.casadobayonantoniojesus.edutrack.repository.ProfesorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;
    private final ProfesorRepository profesorRepository;


    @Transactional(readOnly = true)
    public Matricula matricularAlumno(CreateMatriculaRequest dto){

        Alumno alumno = alumnoRepository.findById(dto.alumnoId())
                .orElseThrow(()-> new EntityNotFoundException("Alumno no encontrado"));

        Curso curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(()-> new EntityNotFoundException("Curso no encontrado"));

        if(!curso.getActivo()){
            throw new IllegalArgumentException("No se pueden realizar matriculas en un curso inactivo");
        }


        MatriculaId id = new MatriculaId(dto.alumnoId(), dto.cursoId());
        if (matriculaRepository.existsById(id)) {
            throw new IllegalArgumentException("El alumno ya está matriculado en este curso");
        }



        long matriculasActivas = matriculaRepository.countByCursoIdAndEstado(dto.cursoId(), "ACTIVO");

        if (matriculasActivas >= curso.getPlazasMaximas()) {
            throw new IllegalArgumentException("El curso ha alcanzado el límite de plazas máximas");
        }


        Matricula matricula = Matricula.builder()
                .id(id)
                .alumno(alumno)
                .curso(curso)
                .fechaMatricula(LocalDateTime.now())
                .estado(Estado.APROBADO)
                .build();

        return matriculaRepository.save(matricula);
    }


    public void asignarNota ( Long alumnoId, Long cursoId, Double nota){

        MatriculaId idCompuesto = new MatriculaId(alumnoId, cursoId);


        Matricula matricula = matriculaRepository.findById(idCompuesto)
                .orElseThrow(() -> new EntityNotFoundException("Matrícula no encontrada"));



        if (matricula.getEstado() != Estado.APROBADO) {
            throw new IllegalArgumentException("Solo se puede calificar si el alumno ya está APROBADO");
        }


        matricula.setNotaFinal(nota);


        if (nota >= 5) {
            matricula.setEstado(Estado.APROBADO);
        } else {
            matricula.setEstado(Estado.SUSPENSO);
        }


    }




    }




