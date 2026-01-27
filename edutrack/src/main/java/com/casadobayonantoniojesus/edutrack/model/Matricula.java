package com.casadobayonantoniojesus.edutrack.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {

    @EmbeddedId
    private MatriculaId id = new MatriculaId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("alumnoId")
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDateTime fechaMatricula;

    private Double notaFinal;

    @Enumerated(EnumType.STRING)
    private Estado estado;
}
