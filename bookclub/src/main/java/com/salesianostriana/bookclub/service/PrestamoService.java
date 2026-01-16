package com.salesianostriana.bookclub.service;

import com.salesianostriana.bookclub.dto.CreatePrestamoRequest;
import com.salesianostriana.bookclub.dto.PrestamoDto;
import com.salesianostriana.bookclub.model.Estado;
import com.salesianostriana.bookclub.model.Libro;
import com.salesianostriana.bookclub.model.Prestamo;
import com.salesianostriana.bookclub.repository.LibroRepository;
import com.salesianostriana.bookclub.repository.PrestamoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;


    public Prestamo crearPrestamo( CreatePrestamoRequest createPrestamoRequest){

         Libro l = libroRepository.findById(createPrestamoRequest.id())
                 .orElseThrow(()-> new EntityNotFoundException("Libro con %d no encontrado".formatted(createPrestamoRequest.id())));

         if(createPrestamoRequest.libro().getEjemplaresDisponibles()>0)
             throw  new RuntimeException("No hay ejemplares disponible para prestamo");

            createPrestamoRequest.estado().equals(Estado.ACTIVO);
            createPrestamoRequest.libro().setEjemplaresDisponibles(-1);

            Prestamo prestamo = toEntity(createPrestamoRequest);

       return prestamoRepository.save(prestamo);




    }



    public Prestamo devolverPrestamo (PrestamoDto prestamoDto){

        Prestamo p = prestamoRepository.findById()
    }








    public Prestamo toEntity(CreatePrestamoRequest c){

        return Prestamo.builder().
                id(c.id()).
                fechaInicio(c.fechaInicio()).
                estado(c.estado()).
                usuario(c.usuario()).
                libro(c.libro()).
                build();
    }


}
