package com.casadobayonantoniojesus.edutrack.repository;

import com.casadobayonantoniojesus.edutrack.model.Estado;
import com.casadobayonantoniojesus.edutrack.model.Matricula;
import com.casadobayonantoniojesus.edutrack.model.MatriculaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface MatriculaRepository  extends JpaRepository<Matricula,MatriculaId>, JpaSpecificationExecutor<MatriculaId> {


    Matricula findByAlumno_IdAndEstado(Long id, Estado estado);
    long countByCursoIdAndEstado(Long cursoId, String estado);





