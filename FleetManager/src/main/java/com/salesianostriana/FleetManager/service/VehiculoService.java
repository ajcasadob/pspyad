package com.salesianostriana.FleetManager.service;

import com.salesianostriana.FleetManager.model.Estado;
import com.salesianostriana.FleetManager.model.Mantenimiento;
import com.salesianostriana.FleetManager.model.Vehiculo;
import com.salesianostriana.FleetManager.repository.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;




    public Page<Vehiculo> getAll(Estado estado, Pageable pageable){

        Page<Vehiculo> listPageable = vehiculoRepository.findByEstado(estado,pageable);

        if(listPageable.isEmpty())
            throw  new EntityNotFoundException("No hay na");

        return listPageable;

    }








}
