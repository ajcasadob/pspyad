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
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/")
@RequiredArgsConstructor
@Tag(name="Biblioteca", description = "El controlador de bibliotecas, para poder realizar todas las operaciones de gestión")
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
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se han encontrado bibliotecas",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "type": "https://example.com/probs/bibliotecas-not-found",
                                        "title": "Bibliotecas no encontradas",
                                        "status": 404,
                                        "detail": "No hay bibliotecas registradas en el sistema.",
                                        "instance": "/biblioteca/"
                                    }
                                    """)
                    )
            )
    })
    public List<BibliotecaResponse> getAll(){
        return bibliotecaService.getAll()
                .stream()
                .map(BibliotecaResponse::of)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una biblioteca por ID", description = "Obtiene una biblioteca específica según su identificador")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Biblioteca encontrada",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BibliotecaResponse.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "id": 1,
                                        "nombreCiudad": "Madrid",
                                        "nombreBiblioteca": "Biblioteca Nacional de España",
                                        "anoFundacion": "1712-10-29",
                                        "numeroAproxLibros": 30000000,
                                        "descripcion": "La Biblioteca Nacional de España es la biblioteca más grande del país y una de las más importantes del mundo.",
                                        "urlBiblioteca": "https://www.bne.es/"
                                    }
                                    """)
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
    })
    public ResponseEntity<BibliotecaResponse> getById(@PathVariable Integer id){
        return ResponseEntity.ok(
                BibliotecaResponse.of(bibliotecaService.getById(id)));
    }

    @PostMapping
    @Operation(summary = "Crear una nueva biblioteca", description = "Crea una nueva biblioteca en el sistema")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Biblioteca creada correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BibliotecaResponse.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "id": 3,
                                        "nombreCiudad": "Sevilla",
                                        "nombreBiblioteca": "Biblioteca Pública Infanta Elena",
                                        "anoFundacion": "1989-05-15",
                                        "numeroAproxLibros": 500000,
                                        "descripcion": "La Biblioteca Pública Infanta Elena es una de las principales bibliotecas de Sevilla.",
                                        "urlBiblioteca": "https://www.bibliotecaspublicassevilla.es/"
                                    }
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "type": "https://example.com/probs/validation-error",
                                        "title": "Error de validación",
                                        "status": 400,
                                        "detail": "Los datos proporcionados no son válidos. Verifica los campos obligatorios.",
                                        "instance": "/biblioteca/"
                                    }
                                    """)
                    )
            )
    })
    public ResponseEntity<BibliotecaResponse> create(
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
                                    """)
                    )
            )
            @RequestBody CrearBibliotecaCmd cmd)
    {
        Biblioteca nuevo = bibliotecaService.save(cmd);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BibliotecaResponse.of(nuevo));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una biblioteca existente", description = "Actualiza los datos de una biblioteca existente")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Biblioteca actualizada correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BibliotecaResponse.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "id": 1,
                                        "nombreCiudad": "Madrid",
                                        "nombreBiblioteca": "Biblioteca Nacional de España - Actualizada",
                                        "anoFundacion": "1712-10-29",
                                        "numeroAproxLibros": 35000000,
                                        "descripcion": "Descripción actualizada de la biblioteca.",
                                        "urlBiblioteca": "https://www.bne.es/"
                                    }
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "type": "https://example.com/probs/validation-error",
                                        "title": "Error de validación",
                                        "status": 400,
                                        "detail": "Los datos proporcionados no son válidos. Verifica los campos obligatorios.",
                                        "instance": "/biblioteca/{id}"
                                    }
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Biblioteca no encontrada",
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
    })
    public ResponseEntity<BibliotecaResponse> edit(
            @PathVariable Integer id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos actualizados de la biblioteca",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = CrearBibliotecaCmd.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "nombreCiudad": "Madrid",
                                        "nombreBiblioteca": "Biblioteca Nacional de España - Actualizada",
                                        "anoFundacion": "1712-10-29",
                                        "numeroAproxLibros": 35000000,
                                        "descripcion": "Descripción actualizada de la biblioteca.",
                                        "urlBiblioteca": "https://www.bne.es/"
                                    }
                                    """)
                    )
            )
            @RequestBody CrearBibliotecaCmd cmd){
        return ResponseEntity.ok(
                BibliotecaResponse.of(
                        bibliotecaService.edit(cmd, id)
                )
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una biblioteca", description = "Elimina una biblioteca del sistema")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Biblioteca eliminada correctamente",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Biblioteca no encontrada",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "type": "https://example.com/probs/biblioteca-not-found",
                                        "title": "Biblioteca no encontrada",
                                        "status": 404,
                                        "detail": "No se ha encontrado ninguna biblioteca con el ID proporcionado para eliminar.",
                                        "instance": "/biblioteca/{id}"
                                    }
                                    """)
                    )
            )
    })
    public ResponseEntity<?> delete(@PathVariable Integer id){
        bibliotecaService.deleleById(id);
        return ResponseEntity.noContent().build();
    }
}
