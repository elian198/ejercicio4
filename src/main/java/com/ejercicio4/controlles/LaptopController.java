package com.ejercicio4.controlles;

import com.ejercicio4.entities.Laptop;
import com.ejercicio4.repositories.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
Ejercicio 2
Dentro de la misma app crear las clases necesarias para trabajar con "ordenadores":
Laptop (entidad)
LaptopRepository (repositorio)
LaptopController (controlador)
Desde LaptopController crear un método que devuelva una lista de objetos Laptop.
Probar que funciona desde Postman.
Los objetos Laptop se pueden insertar desde el método main de la clase principal.
 */
/*
Implementar los métodos CRUD en el API REST de Laptop creada en ejercicios anteriores.
Los métodos CRUD:
findAll()   findOneById()   create()   update() delete()  deleteAll()
 */
@RestController
public class LaptopController {

    LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> fildAll(){
        return  laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id){
        Optional<Laptop> oneLaptop = laptopRepository.findById(id);
        if (oneLaptop.isPresent()) {
            return ResponseEntity.ok(oneLaptop.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/laptops/")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders header ){
        System.out.println(header.get("User-Agent"));
        if(laptop.getId()!=null){
            return ResponseEntity.badRequest().build();
        }
        else {
            Laptop laptop1 = laptopRepository.save(laptop);
            return ResponseEntity.ok(laptop1);
        }
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            return  ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            return ResponseEntity.notFound().build();
        }
        Laptop laptop1 = laptopRepository.save(laptop);
        return ResponseEntity.ok(laptop1);
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            return ResponseEntity.badRequest().build();
        }
       laptopRepository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
