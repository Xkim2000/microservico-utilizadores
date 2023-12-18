package com.ad.microservicoutilizadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicoUtilizadores implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicoUtilizadores.class, args);
	}

	@Autowired
	RepositorioUtilizadores repositorioUtilizadores;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		repositorioUtilizadores.save(new Utilizador("Ana", "Sarzedas", "ana@gmail.com", "joaquim"));
	}
}
