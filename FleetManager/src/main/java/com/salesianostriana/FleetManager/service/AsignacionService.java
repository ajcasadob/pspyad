package com.salesianostriana.FleetManager.service;

import com.salesianostriana.FleetManager.dto.CreateAsignacionRequest;
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



    public Asignacion crearAsignacionVehiculo(CreateAsignacionRequest asignacionRequest) {

        Vehiculo vehiculo = vehiculoRepository.findById(asignacionRequest.vehiculoId())
                .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado con ID: " + asignacionRequest.vehiculoId()));


        if (vehiculo.getEstado() != Estado.DISPONIBLE) {
            throw new IllegalStateException("El vehículo no está disponible para asignación.");
        }

        Conductor conductor = conductorRepository.findById(asignacionRequest.conductorId())
                .orElseThrow(() -> new EntityNotFoundException("Conductor no encontrado con ID: " + asignacionRequest.conductorId()));

        if (asignacionRepository.existsByConductorIdAndFechaFinIsNull(asignacionRequest.conductorId())) {
            throw new IllegalStateException("El conductor ya tiene una asignación activa");
        }

        if(asignacionRepository.existsByVehiculo_IdAndFechaFinNull(asignacionRequest.vehiculoId()))
            throw new IllegalStateException("El vehiculo ya tiene una asignacion activa");


        Asignacion asignacion = toEntity(asignacionRequest,vehiculo,conductor);

        asignacion.setVehiculo(vehiculo);
        asignacion.setFechaInicio(LocalDate.now());
        asignacion.setConductor(conductor);


        vehiculo.setEstado(Estado.ASIGNADO);
        vehiculoRepository.save(vehiculo);

        return asignacionRepository.save(asignacion);

    }

    public void cerrarAsignacion(Long asignacionId){
        Asignacion asignacion = asignacionRepository.findById(asignacionId)
                .orElseThrow(()-> new EntityNotFoundException("Asignación no encontrada"));

        if(asignacion.getFechaFin()!=null){
            throw  new RuntimeException("La asignación ya está cerrada");
        }
        asignacion.setFechaFin(LocalDate.now());
        asignacion.getVehiculo().setEstado(Estado.DISPONIBLE);

        asignacionRepository.save(asignacion);
    }

    public Asignacion toEntity(CreateAsignacionRequest asignacionRequest, Vehiculo vehiculo, Conductor conductor){
        return Asignacion.builder()
                .fechaInicio(asignacionRequest.fechaInicio())
                .fechaFin(asignacionRequest.fechaFin())
                .vehiculo(vehiculo)
                .conductor(conductor)
                .build();
    }











}









