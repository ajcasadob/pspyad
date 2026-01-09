package com.salesianostriana.tribici.repository;

import com.salesianostriana.tribici.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionRepository extends JpaRepository<Estacion,Long> {
}
