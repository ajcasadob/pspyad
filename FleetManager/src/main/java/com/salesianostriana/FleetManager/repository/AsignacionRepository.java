package com.salesianostriana.FleetManager.repository;

import com.salesianostriana.FleetManager.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion,Long> {

    boolean existsByConductorIdAndFechaFinIsNull(Long conductorId);

    boolean existsByVehiculo_IdAndFechaFinNull(Long id);

}
