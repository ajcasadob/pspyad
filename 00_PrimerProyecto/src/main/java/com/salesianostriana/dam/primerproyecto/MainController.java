package com.salesianostriana.dam.primerproyecto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/person")
    public Person getPerson ( ){
        return  new Person (1L,"Antonio", "Casado");
    }


  public record Person (Long id, String firstName, String lastName){}

}
