package com.salesianostrianacasadobayon.biblioteca.controller;


import com.salesianostrianacasadobayon.biblioteca.dto.BibliotecaResponse;
import com.salesianostrianacasadobayon.biblioteca.dto.CrearBibliotecaCmd;
import com.salesianostrianacasadobayon.biblioteca.model.Biblioteca;
import com.salesianostrianacasadobayon.biblioteca.service.BibliotecaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/")
@RequiredArgsConstructor
@Tag(name="Biblioteca", description = "El controlador de biliotecas, para poder realizar todas las operaciones de gestión")
public class BibliotecaController {


    private final BibliotecaService bibliotecaService;


    @GetMapping
    @Operation(summary = "Obtener todas las bibliotecas", description = "Obtiene una lista de todas las bibliotecas disponibles")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han encontrado bibliotecas",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BibliotecaResponse.class)),
                            examples = @ExampleObject(value = """
                                    [
                                        {
                                            "id": 1,
                                            "nombreCiudad": "Madrid",
                                            "nombreBiblioteca": "Biblioteca Nacional de España",
                                            "anoFundacion": "1712-10-29",
                                            "numeroAproxLibros": 30000000,
                                            "descripcion": "La Biblioteca Nacional de España es la biblioteca más grande del país y una de las más importantes del mundo. Fundada en 1712, alberga una vasta colección de libros, manuscritos, mapas y otros materiales.",
                                            "urlBiblioteca": "https://www.bne.es/"
                                        },
                                        {
                                            "id": 2,
                                            "nombreCiudad": "Barcelona",
                                            "nombreBiblioteca": "Biblioteca de Catalunya",
                                            "anoFundacion": "1907-06-28",
                                            "numeroAproxLibros": 3500000,
                                            "descripcion": "La Biblioteca de Catalunya es la biblioteca nacional de Cataluña. Fundada en 1907, cuenta con una amplia colección de libros y documentos relacionados con la cultura catalana.",
                                            "urlBiblioteca": "https://www.bnc.cat/"
                                        }
                                        ]
                                    
                                    """)
                    )
            )
    })
    public List<BibliotecaResponse> getAll(){
        return bibliotecaService.getAll()
                .stream()
                .map(BibliotecaResponse::of )
                .toList();
    }


    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Blibloteca encontrada",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BibliotecaResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No se ha encontrado la biblioteca",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProblemDetail.class),
                                    examples = @ExampleObject(value = """
                                            {
                                                "type": "https://example.com/probs/biblioteca-not-found",
                                                "title": "Biblioteca no encontrada",
                                                "status": 404,
                                                "detail": "No se ha encontrado ninguna biblioteca con el ID proporcionado.",
                                                "instance": "/biblioteca/{id}"
                                            }
                                            """)
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<BibliotecaResponse> getById (@PathVariable Integer id){
        return ResponseEntity.ok(
                BibliotecaResponse.of(bibliotecaService.getById(id)));

    }

    @PostMapping
    public ResponseEntity<BibliotecaResponse> create (
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos necesarios para crear una nueva biblioteca",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = CrearBibliotecaCmd.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "nombreCiudad": "Sevilla",
                                        "nombreBiblioteca": "Biblioteca Pública Infanta Elena",
                                        "anoFundacion": "1989-05-15",
                                        "numeroAproxLibros": 500000,
                                        "descripcion": "La Biblioteca Pública Infanta Elena es una de las principales bibliotecas de Sevilla. Fundada en 1989, ofrece una amplia gama de servicios y recursos para la comunidad.",
                                        "urlBiblioteca": "https://www.bibliotecaspublicassevilla.es/"
                                    }
                                    """
                            )
            )
    )
            @RequestBody CrearBibliotecaCmd cmd)
    {
        Biblioteca nuevo = bibliotecaService.save(cmd);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BibliotecaResponse.of(nuevo));

    }

    @PutMapping("/{id}")
    public ResponseEntity<BibliotecaResponse> edit (
            @PathVariable Integer id,
            @RequestBody CrearBibliotecaCmd cmd){
        return ResponseEntity.ok(
                BibliotecaResponse.of(
                        bibliotecaService.edit(cmd, id)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id){
        bibliotecaService.deleleById(id);
        return ResponseEntity.noContent().build();
    }



}
