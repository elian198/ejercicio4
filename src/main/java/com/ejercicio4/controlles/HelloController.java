package com.ejercicio4.controlles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /*
    Ejercicio 1
Crear un proyecto Spring Boot con las dependencias:
H2   Spring Data JPA  Spring Web   Spring Boot dev tools
Crear una clase HelloController que sea un controlador REST. Dentro de
 la clase crear un método que retorne un saludo. Probar que retorna el
  saludo desde el navegador y desde Postman.
     */
    @Value("${app.message}")
    String message;
    @GetMapping("/laptops")
    public String saludo(){
        System.out.println(message);
        return " hola mundo";
    }

}
