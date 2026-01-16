package com.salesianostriana.bookclub.controller;

import com.salesianostriana.bookclub.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;
}
