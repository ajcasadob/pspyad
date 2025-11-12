package com.salesianostrianadam.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Direccion {


    private Long id;
    private String tipoVia;
    private String linea1;
    private String linea2;
    private Long cp;
    private String poblacion;
    private String provincia;
}
