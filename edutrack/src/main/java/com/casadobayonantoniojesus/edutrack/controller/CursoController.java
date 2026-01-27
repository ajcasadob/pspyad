package com.casadobayonantoniojesus.edutrack.controller;

import com.casadobayonantoniojesus.edutrack.dto.CursoDetailDto;
import com.casadobayonantoniojesus.edutrack.dto.CursoResponse;
import com.casadobayonantoniojesus.edutrack.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CursoController {

    private final CursoService service;

    @GetMapping("api/v1/cursos")
    public ResponseEntity<Page<CursoResponse>> filtrarCursos (@PageableDefault(
            page = 0,
            size = 10,
            sort = "nombre",
            direction = Sort.Direction.DESC)Pageable pageable,
                                                              @RequestParam (required = false) String nombre,
                                                              @RequestParam (required = false) String nivel,
                                                              @RequestParam(required = false) Integer plazaMaxima,
                                                              @RequestParam (required = false) Boolean activo){

        CursoDetailDto filtro = new CursoDetailDto(nivel,activo,nombre,plazaMaxima);

        return ResponseEntity.ok(service.filtrado(pageable,filtro).map(CursoResponse::of));
    }

}
