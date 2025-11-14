package com.salesianostrianaapimonumentos.dam.controller;

import com.salesianostrianaapimonumentos.dam.dto.MonumentoDTO;
import com.salesianostrianaapimonumentos.dam.model.Monumento;
import com.salesianostrianaapimonumentos.dam.service.MonumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monument/")
public class MonumentoController {


    private final MonumentoService monumentoService;



    @GetMapping
    public List<Monumento> getAll(){

        return monumentoService.findAll();
    }

    @GetMapping("/{id}")
    public Monumento getById (@PathVariable Long id){
        return monumentoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Monumento> crear (@RequestBody MonumentoDTO monumentoDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monumentoService.save(monumentoDTO));
    }

    @PutMapping("*/{id}")
    public Monumento edit (@RequestBody MonumentoDTO monumentoDTO, @PathVariable Long id){
        return monumentoService.edit(monumentoDTO,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        monumentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
