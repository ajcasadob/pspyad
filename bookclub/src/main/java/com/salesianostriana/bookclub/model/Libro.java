package com.salesianostriana.bookclub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Libro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    private Integer ejemplaresDisponibles;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "libro",fetch = FetchType.LAZY)
    private List<Prestamo> prestamoList = new ArrayList<>();
}
