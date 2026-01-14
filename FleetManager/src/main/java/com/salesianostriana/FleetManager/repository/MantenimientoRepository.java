package com.salesianostriana.FleetManager.repository;

import com.salesianostriana.FleetManager.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento,Long> {


    List<Mantenimiento> findByVehiculo_Id(Long id);


    @Query("""
        SELECT m FROM Mantenimiento m
        WHERE m.vehiculo.id = :vehiculoId
        AND m.fecha = (
            SELECT MAX(m2.fecha) 
            FROM Mantenimiento m2 
            WHERE m2.vehiculo.id = :vehiculoId
        )
        """)
    Optional<Mantenimiento> findUltimoMantenimientoDeVehiculo(@Param("vehiculoId") Long vehiculoId);

}
