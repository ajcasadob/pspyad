package com.salesianostrianadam.dto2;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {


    private Long id;
    private String nombre;
    private double desc;
    private double pvp;
    private List<String> imagenes;
    private Categoria categoria;

}
