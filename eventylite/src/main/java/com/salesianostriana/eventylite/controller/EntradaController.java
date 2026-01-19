package com.salesianostriana.eventylite.controller;

import com.salesianostriana.eventylite.dto.CreateEntradaRequest;
import com.salesianostriana.eventylite.dto.EntradaDto;
import com.salesianostriana.eventylite.service.EntradaService;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EntradaController {

    private final EntradaService entradaService;



    @PostMapping("/entradas")
    public ResponseEntity<EntradaDto> comprarEntrada (@RequestParam CreateEntradaRequest createEntradaRequest){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EntradaDto.of(entradaService.comprarEntradas(createEntradaRequest)));
    }

    @PutMapping("/entradas/{id}/cancelar")
    public ResponseEntity<EntradaDto> cancelarEntrada (@PathVariable Long id){
        return ResponseEntity.ok(EntradaDto.of(entradaService.cancelarEntradas(id)));
    }

    @GetMapping("/eventos/{id}/entradas")
    public Page<EntradaDto> mostrarInfo (@PathVariable Long eventoId, @PageableDefault(page = 0,size = 20)Pageable pageable){
        return entradaService.mostrarInfo(eventoId,pageable).map(EntradaDto::of);
    }
}
