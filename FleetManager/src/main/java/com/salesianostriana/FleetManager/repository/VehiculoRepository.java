package com.salesianostriana.FleetManager.repository;

import com.salesianostriana.FleetManager.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {
}
