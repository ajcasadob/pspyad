package com.salesianostriana.ejemploejercicio.model;

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
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    private Boolean baneado;

    @Builder.Default
    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private List<Reserva> reservaList = new ArrayList<>();

}
