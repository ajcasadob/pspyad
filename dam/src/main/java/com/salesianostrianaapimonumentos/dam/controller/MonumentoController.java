package com.salesianostrianaapimonumentos.dam.controller;

import com.salesianostrianaapimonumentos.dam.dto.MonumentoDTO;
import com.salesianostrianaapimonumentos.dam.model.Monumento;
import com.salesianostrianaapimonumentos.dam.service.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monument/")
@Tag(name = "Monumento", description = "El controlador de monumentos, para poder realizar todas las operaciones de gestión")
public class MonumentoController {


    private final MonumentoService monumentoService;



    @GetMapping
    @Operation(summary ="Obtiene todos los monumentos almacenados",
    description = "Devuelve una lista de monumentos. ")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han encontrado monumentos",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MonumentoDTO.class)),
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                "descripcion": "La Giralda de Sevilla es muy bonita"
                                                "pais": "España"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(responseCode = "404", description = "No se ha encontrado monumentos")
    })
    public List<Monumento> getAll(){

        return monumentoService.findAll();
    }

    @GetMapping("/{id}")
    public Monumento getById (@PathVariable Long id){
        return monumentoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Monumento> crear (@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos necesarios para crear un nuevo monumento",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = MonumentoDTO.class),
                    examples = @ExampleObject(
                            value = """
                                    {
                                       "descripcion": "La Giralda de Sevilla es muy bonita porque yo he estado allí",
                                        "pais": "España"
                                     }
                                    """
                    )
            )
    )
            @RequestBody MonumentoDTO monumentoDTO){
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
