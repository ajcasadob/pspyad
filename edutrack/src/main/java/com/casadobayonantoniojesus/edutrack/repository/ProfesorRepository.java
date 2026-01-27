package com.casadobayonantoniojesus.edutrack.repository;

import com.casadobayonantoniojesus.edutrack.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long>, JpaSpecificationExecutor<Profesor> {
}
