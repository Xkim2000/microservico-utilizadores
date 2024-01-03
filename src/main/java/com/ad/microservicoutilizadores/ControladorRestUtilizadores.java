package com.ad.microservicoutilizadores;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
public class ControladorRestUtilizadores {

    @Autowired
    private RepositorioUtilizadores repositorioUtilizadores;

    @PostMapping("/registar")
    public Utilizador registarUtilizador(@RequestBody Utilizador utilizador) throws Exception {
        try {
            //Verifica antes de registar se o utilizador já existe
            Utilizador utilizadorexistente = verificarUtilizador(utilizador.getNome()).orElse(null);
            if (utilizadorexistente != null) {
                throw new ResponseStatusException(HttpStatus.IM_USED);
            }
            this.repositorioUtilizadores.save(utilizador);
            return utilizador;
        }  catch (Exception e) {
            //Aqui apanha erro devolvido pela BD.
            throw new Exception(e.getMessage());
            //return null;
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

    @GetMapping("/admin/listarutilizadores")
    public List<Utilizador> listarTodosUtilizadores(){return repositorioUtilizadores.findAllBy();}

    @Transactional
    @DeleteMapping("/deleteutilizadores/{id}")
    public void apagarUtilizador(@PathVariable Integer id) {
        if(!repositorioUtilizadores.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else
            repositorioUtilizadores.deleteById(id);
    }

}
