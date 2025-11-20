package com.salesianostrianacasadobayon.biblioteca.service;

import com.salesianostrianacasadobayon.biblioteca.error.InvalidLibraryDataException;
import com.salesianostrianacasadobayon.biblioteca.error.LibraryNotFoundException;
import com.salesianostrianacasadobayon.biblioteca.model.Biblioteca;
import com.salesianostrianacasadobayon.biblioteca.dto.CrearBibliotecaCmd;
import com.salesianostrianacasadobayon.biblioteca.repository.BibliotecaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;


    public List<Biblioteca> getAll(){

        List<Biblioteca> result = bibliotecaRepository.findAll();

        if(result.isEmpty())
            throw new LibraryNotFoundException("No hay bibliotecas registradas.");
        return result;
    }

    public Biblioteca getById (Long id){
        return bibliotecaRepository.findById(id)
                .orElseThrow(()-> new LibraryNotFoundException(id));
    }

    public Biblioteca save (CrearBibliotecaCmd cmd ){

        if (!StringUtils.hasText(cmd.nombreBiblioteca())){
            throw  new InvalidLibraryDataException("Error al crear la biblioteca");
        }

        return bibliotecaRepository.save(cmd.toEntity());

    }

    public Biblioteca edit (CrearBibliotecaCmd cmd, Long id){

        return bibliotecaRepository.findById(id)
                .map(biblioteca-> {

                    biblioteca.setNombreBiblioteca(cmd.nombreBiblioteca());
                    biblioteca.setDescripcion(cmd.descripcion());
                    biblioteca.setNombreCiudad(cmd.nombreCiudad());
                    biblioteca.setNumeroAproxLibros(cmd.numeroAproxLibros());
                    biblioteca.setUrlBiblioteca(cmd.urlBiblioteca());
                    biblioteca.setAnoFundacion(  java.time.LocalDate.parse( cmd.anoFundacion()));

                    return bibliotecaRepository.save(biblioteca);

        })
                .orElseThrow(()-> new LibraryNotFoundException(id));
    }

    public void delete (Biblioteca biblioteca){
        deleleById(biblioteca.getId());
    }

    public void deleleById(Long id){
        bibliotecaRepository.deleteById(id);
    }

}
