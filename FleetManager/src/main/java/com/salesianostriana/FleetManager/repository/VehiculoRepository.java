package com.salesianostriana.FleetManager.repository;

import com.salesianostriana.FleetManager.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {
}
