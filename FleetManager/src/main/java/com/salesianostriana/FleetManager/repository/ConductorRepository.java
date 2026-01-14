package com.salesianostriana.FleetManager.repository;

import com.salesianostriana.FleetManager.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository extends JpaRepository<Conductor,Long> {
}
