package com.ad.microservicoutilizadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class ControladorRestUtilizadores {

    @Autowired
    private RepositorioUtilizadores repositorioUtilizadores;

    @PostMapping("/registar")
    public Utilizador registarUtilizador(@RequestBody Utilizador utilizador){
        try {
            this.repositorioUtilizadores.save(utilizador);
            return utilizador;
        }  catch (Exception e) {
            //Aqui apanha erro devolvido pela BD.
            //throw new Exception(e.getMessage());
            return null;
        }
    }

    @PostMapping("/verificar-user")
    public Optional<Utilizador> verificarUtilizador(@RequestParam("nome") String nome) {
        try {
            System.out.println(nome);
            Optional<Utilizador> utilizadorEncontrado = this.repositorioUtilizadores.findByNome(nome);
            System.out.println(utilizadorEncontrado);
            return utilizadorEncontrado;
        } catch (Exception e) {
            return Optional.empty(); // ou null, dependendo da sua lógica
        }
    }

}
