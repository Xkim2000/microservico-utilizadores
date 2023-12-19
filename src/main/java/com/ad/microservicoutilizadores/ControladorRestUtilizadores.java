package com.ad.microservicoutilizadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class ControladorRestUtilizadores {

    @Autowired
    private RepositorioUtilizadores repositorioUtilizadores;

    @PostMapping(value = "/registar")
    public Utilizador registarUtilizador(@RequestBody Utilizador utilizador){
        try {
            System.out.println(utilizador);
            this.repositorioUtilizadores.save(utilizador);
            return utilizador;
        }  catch (Exception e) {
            //Aqui apanha erro devolvido pela BD.
            //System.out.println(utilizador.toString());
            // ModelAndView modeloEVista = new ModelAndView();
            //throw new Exception(e.getMessage());
            return null;
        }
    }
    @GetMapping("/loadUser/{username}")
    public UserDetails loadUserByUsername(@PathVariable String username){

        return this.repositorioUtilizadores.findByNome(username).orElseThrow( () -> new UsernameNotFoundException("user invalido"));

    }
}
