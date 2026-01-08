package com.salesianostriana.tribici.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @Column(unique = true)
    private Long numTarjeta;

    private Long pin;

    private double saldo;

    @OneToMany(mappedBy = "usuario")
    @Builder.Default
    private List<Uso> usoList = new ArrayList<>();
}
