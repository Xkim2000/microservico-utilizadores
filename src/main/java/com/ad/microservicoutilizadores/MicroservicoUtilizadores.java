package com.ad.microservicoutilizadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MicroservicoUtilizadores implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicoUtilizadores.class, args);
	}

	@Autowired
	RepositorioUtilizadores repositorioUtilizadores;

	@Autowired
	@Qualifier("codificador.bcrypt")
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//teste:
		//repositorioUtilizadores.save(new Utilizador("Ana", "Sarzedas", "ana@gmail.com", bCryptPasswordEncoder.encode("joaquim")));
	}
}
