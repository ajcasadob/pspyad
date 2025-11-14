package com.salesianostrianaapimonumentos.dam.dto;

import com.salesianostrianaapimonumentos.dam.model.Monumento;
import lombok.Builder;

@Builder
public record MonumentoDTO(
                           String nombreCodigo,
                           String nombrePais,
                           String nombreCiudad,
                           String monumentoNombre,
                           String descripcion,
                           String fotoUrl,
                           double latitud,
                           double longitud) {

    public static MonumentoDTO ObtenerMonumentoDto (Monumento m){

        return MonumentoDTO.builder()
                .nombreCodigo(m.getNombreCodigo())
                .nombrePais(m.getNombrePais())
                .nombreCiudad(m.getNombreCiudad())
                .monumentoNombre(m.getNombreMonumento())
                .descripcion(m.getDescripcion())
                .fotoUrl(m.getUrlFoto())
                .latitud(m.getLatitud())
                .longitud(m.getLongitud()).build();
    }
}
