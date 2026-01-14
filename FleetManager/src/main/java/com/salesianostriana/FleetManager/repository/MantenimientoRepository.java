package com.salesianostriana.FleetManager.repository;

import com.salesianostriana.FleetManager.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento,Long> {
}
