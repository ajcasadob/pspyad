package com.salesianostriana.viviendafilter.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "viviendas")
public class Vivienda {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo,descripcion,ciudad,provincia;
    private Integer precio,metrosCuadrados,habitaciones,banos;

    @Enumerated(EnumType.STRING)
    private TipoVivienda tipoVivienda;
    @Enumerated(EnumType.STRING)
    private EstadoVivienda estadoVivienda;

    private Boolean ascensor,terraza,garaje,disponible;

    private LocalDate fechaPublicacion;

}
