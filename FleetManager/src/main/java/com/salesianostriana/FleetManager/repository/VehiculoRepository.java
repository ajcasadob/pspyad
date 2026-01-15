package com.salesianostriana.FleetManager.repository;

import com.salesianostriana.FleetManager.model.Estado;
import com.salesianostriana.FleetManager.model.Mantenimiento;
import com.salesianostriana.FleetManager.model.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {


    Page<Vehiculo> findVehiculos( Pageable pageable);



}
