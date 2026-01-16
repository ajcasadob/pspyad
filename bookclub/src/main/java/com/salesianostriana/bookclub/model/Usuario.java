package com.salesianostriana.bookclub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private List<Prestamo> prestamoList = new ArrayList<>();
}
