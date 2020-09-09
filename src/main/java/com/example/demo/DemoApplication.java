package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Libro;
import com.example.demo.model.LibroService;
import com.example.demo.model.MMusic;
import com.example.demo.model.MUser;
import com.example.demo.model.Persona;
import com.example.demo.model.PersonaService;
import com.example.demo.model.TUseResult;
import com.example.demo.service.MMusicService;
import com.example.demo.service.MUserService;
import com.example.demo.service.TUseResultService;

@SpringBootApplication
public class DemoApplication {

	// JPA
	// https://www.objectdb.com/java/jpa/entity/id

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LibroService libroService, PersonaService personaService,
			MUserService mUserService, MMusicService mMusicService, TUseResultService tUseResultService) {
		return (args) -> {
			// crear datos al arrancar la aplicación
			// se usa para meter datos de prueba
			Persona alice = new Persona("Alice", "Wonderland", "666");
			Persona ali = new Persona("Ali", "Baba", "777");
			personaService.add(alice);
			personaService.add(ali);

			Libro libro1 = new Libro(12312l, "Introduccion a Spring", 100d, alice, ali);
			Libro libro2 = new Libro(1122l, "Como aprobar introduccion a la ingeniería", 1000d, ali, alice);
			libroService.add(libro1);
			libroService.add(libro2);

			// ejemplo de como buscar por nombre
			Libro l1 = libroService.getByName("Introduccion a Spring");
			Libro libroInexistente = libroService.getByName("NONAME");

			MUser user = new MUser(new Integer(1), "1", "秋元康","1",LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			mUserService.save(user);
			MMusic music = new MMusic(new Integer(1), "1", "川の流れのように",
					"1",new BigDecimal(1002),
					"2",new BigDecimal(102),
					"3",new BigDecimal(522),
					"4",new BigDecimal(632),
					"5",new BigDecimal(874),
					LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			mMusicService.save(music);

			TUseResult newTUseResult = new TUseResult(new Integer(1), user,
	                music, new BigDecimal(123), LocalDate.of(1997, 1, 22), "品川",  LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			tUseResultService.save(newTUseResult);
		};
	}

}
