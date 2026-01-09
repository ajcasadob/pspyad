package com.salesianostriana.tribici.service;

import com.salesianostriana.tribici.model.Bicicleta;
import com.salesianostriana.tribici.repository.BicicletaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;



    public List<Bicicleta> findAll() {

        List<Bicicleta> listaBicicletas = bicicletaRepository.findAll();
        if(listaBicicletas.isEmpty()){
            throw new RuntimeException("No hay bicicletas disponibles");
        }
        return listaBicicletas;
    }

   public Bicicleta findById(Long id) {

        return bicicletaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se ha encontrado la bicicleta con id: " + id));
    }

    public Bicicleta crear ( Bicicleta bicicleta){

        if(!StringUtils.hasText(bicicleta.getModelo())){
            throw new RuntimeException("El modelo de la bicicleta no puede estar vacío");
        }
        return bicicletaRepository.save(bicicleta);


    }


}
