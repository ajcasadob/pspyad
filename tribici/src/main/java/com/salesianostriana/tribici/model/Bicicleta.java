package com.salesianostriana.tribici.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Bicicleta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String marca;

    private String modelo;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    private Estacion estacion;

    @OneToMany(mappedBy = "bicicleta")
    @Builder.Default
    private List<Uso> uso = new ArrayList<>();
}
