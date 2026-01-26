package com.salesianostriana.ejemploejercicio.repository;

import com.salesianostriana.ejemploejercicio.model.Sala;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>, JpaSpecificationExecutor<Sala> {
}
