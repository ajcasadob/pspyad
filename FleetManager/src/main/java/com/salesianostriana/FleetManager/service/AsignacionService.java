package com.salesianostriana.FleetManager.service;

import com.salesianostriana.FleetManager.model.Asignacion;
import com.salesianostriana.FleetManager.model.Conductor;
import com.salesianostriana.FleetManager.model.Estado;
import com.salesianostriana.FleetManager.model.Vehiculo;
import com.salesianostriana.FleetManager.repository.AsignacionRepository;
import com.salesianostriana.FleetManager.repository.ConductorRepository;
import com.salesianostriana.FleetManager.repository.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AsignacionService {

    private final AsignacionRepository asignacionRepository;
    private final VehiculoRepository vehiculoRepository;
    private final ConductorRepository conductorRepository;



    public Asignacion crearAsignacionVehiculo(Asignacion asignacion, Long vehiculoId,Long conductorId) {

        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado con ID: " + vehiculoId));


        if (vehiculo.getEstado() != Estado.DISPONIBLE) {
            throw new IllegalStateException("El vehículo no está disponible para asignación.");
        }

        Conductor conductor = conductorRepository.findById(conductorId)
                .orElseThrow(() -> new EntityNotFoundException("Conductor no encontrado con ID: " + conductorId));

        if (asignacionRepository.existsByConductorIdAndFechaFinIsNull(conductorId)) {
            throw new IllegalStateException("El conductor ya tiene una asignación activa");
        }

        if(asignacionRepository.existsByVehiculo_IdAndFechaFinNull(vehiculoId))
            throw new IllegalStateException("El vehiculo ya tiene una asignacion activa");


        asignacion.setVehiculo(vehiculo);
        asignacion.setFechaInicio(LocalDate.now());
        asignacion.setConductor(conductor);


        vehiculo.setEstado(Estado.ASIGNADO);
        vehiculoRepository.save(vehiculo);

        return asignacionRepository.save(asignacion);

    }











}









