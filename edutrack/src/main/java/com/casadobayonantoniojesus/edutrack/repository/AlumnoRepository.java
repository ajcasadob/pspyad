package com.casadobayonantoniojesus.edutrack.repository;

import com.casadobayonantoniojesus.edutrack.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long>, JpaSpecificationExecutor<Alumno> {
}
