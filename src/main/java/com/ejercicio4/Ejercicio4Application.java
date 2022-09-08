package com.ejercicio4;

import com.ejercicio4.entities.Laptop;
import com.ejercicio4.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/*
Ejercicio 3
Crear un método en LaptopController que reciba un objeto
Laptop enviado en formato JSON desde Postman y persistirlo en la base de datos.
Comprobar que al obtener de nuevo los laptops aparece el nuevo ordenador creado.
 */
@SpringBootApplication
public class Ejercicio4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejercicio4Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);
		Laptop laptop = new Laptop(null,"lenovo",150000.0);

		repository.save(laptop);
	}

}
