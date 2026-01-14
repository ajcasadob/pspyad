package com.salesianostriana.FleetManager.service;

import com.salesianostriana.FleetManager.dto.CreateMantenimientoRequest;
import com.salesianostriana.FleetManager.model.Estado;
import com.salesianostriana.FleetManager.model.Mantenimiento;
import com.salesianostriana.FleetManager.model.Taller;
import com.salesianostriana.FleetManager.model.Vehiculo;
import com.salesianostriana.FleetManager.repository.MantenimientoRepository;
import com.salesianostriana.FleetManager.repository.TallerRepository;
import com.salesianostriana.FleetManager.repository.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;
    private final VehiculoRepository vehiculoRepository;
    private final TallerRepository tallerRepository;





    public Mantenimiento crearMantenimiento(CreateMantenimientoRequest mantenimientoRequest) {

        Vehiculo v = vehiculoRepository.findById(mantenimientoRequest.vehiculoId())
                .orElseThrow(()-> new EntityNotFoundException("Vehículo con id %d no encontrado".formatted(mantenimientoRequest.vehiculoId())));

        Taller t = tallerRepository.findById(mantenimientoRequest.tallerId()).orElseThrow(
                ()->new EntityNotFoundException("No se encuentra el taller con id %d".formatted(mantenimientoRequest.tallerId())));

        if (v.getEstado().equals(Estado.ASIGNADO))
            throw new RuntimeException("No se puede asignar el mantenimiento");


        if(v.getKmActuales()<mantenimientoRequest.kmEnRevision())
            throw new RuntimeException("El kilometro debe ser mayor o igual al km actual del vehiculo");

        v.setEstado(Estado.EN_MANTENIMIENTO);
        v.setKmActuales(mantenimientoRequest.kmEnRevision());

        Mantenimiento mantenimiento = toEntity(mantenimientoRequest,v,t);


        return mantenimientoRepository.save(mantenimiento);





    }

    public List<Mantenimiento> obtenerMantenimientoDeVehiculo(Long vehiculoId){

        if(!vehiculoRepository.existsById(vehiculoId))
            throw  new EntityNotFoundException("Vehículo con id %d no encontrado".formatted(vehiculoId));

        return mantenimientoRepository.findByVehiculo_Id(vehiculoId);
    }

    public Optional<Mantenimiento> obtenerUltimoMantenimiento(Long vehiculoId){

        return mantenimientoRepository.findUltimoMantenimientoDeVehiculo(vehiculoId);
    }

    public Mantenimiento toEntity(CreateMantenimientoRequest mantenimientoRequest, Vehiculo vehiculo, Taller taller){
        return Mantenimiento.builder()
                .tipo(mantenimientoRequest.tipo())
                .fecha(mantenimientoRequest.fecha())
                .kmEnRevision(mantenimientoRequest.kmEnRevision())
                .vehiculo(vehiculo)
                .taller(taller)
                .build();
    }



}
