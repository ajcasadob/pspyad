package com.casadobayonantoniojesus.ejemplos.repository;

import com.casadobayonantoniojesus.ejemplos.model.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {
}
