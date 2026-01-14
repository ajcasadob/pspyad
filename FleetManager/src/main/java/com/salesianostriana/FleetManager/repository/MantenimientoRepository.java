package com.salesianostriana.FleetManager.repository;

import com.salesianostriana.FleetManager.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento,Long> {
}
