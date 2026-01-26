package com.salesianostriana.viviendafilter.controller;

import com.salesianostriana.viviendafilter.dto.FiltradoDto;
import com.salesianostriana.viviendafilter.dto.ViviendaResponse;
import com.salesianostriana.viviendafilter.model.EstadoVivienda;
import com.salesianostriana.viviendafilter.model.TipoVivienda;
import com.salesianostriana.viviendafilter.service.ViviendaFilter;
import com.salesianostriana.viviendafilter.service.ViviendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ViviendaController {

    private final ViviendaService viviendaService;


    @GetMapping("api/v1/viviendas")
    public ResponseEntity<Page<ViviendaResponse>> obtenerViviendas (
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "fechaPublicacion",
                    direction = Sort.Direction.DESC)Pageable pageable,
            @RequestParam(required = false) String ciudad,
            @RequestParam(required = false) String provincia,
            @RequestParam(required = false) Double precioMin,
            @RequestParam(required = false) Double precioMax,
            @RequestParam(required = false) Double metrosMin,
            @RequestParam(required = false) Double metrosMax,
            @RequestParam(required = false) Integer habitacionesMin,
            @RequestParam(required = false) Integer banosMin,
            @RequestParam(required = false)TipoVivienda tipo,
            @RequestParam(required = false)EstadoVivienda estado,
            @RequestParam(required = false) Boolean ascensor,
            @RequestParam(required = false) Boolean terraza,
            @RequestParam(required = false) Boolean garaje,
            @RequestParam(required = false) Boolean disponibilidad
            ){
        FiltradoDto filtrado = new FiltradoDto(
                ciudad,provincia,precioMin,precioMax,metrosMin,metrosMax,habitacionesMin,banosMin,tipo,estado,ascensor,terraza,garaje,disponibilidad
        );
        return ResponseEntity.ok(viviendaService.filtrado(pageable,filtrado).map(ViviendaResponse::of));

    }

}
