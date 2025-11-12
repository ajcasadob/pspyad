package com.salesianostrianadam.dto2;

import java.util.List;

public record ProductoDTO(String nombre, double pvp, List<String> imagenes, Categoria categoria) {
}
