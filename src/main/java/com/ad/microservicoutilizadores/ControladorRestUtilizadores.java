package com.ad.microservicoutilizadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControladorRestUtilizadores {

    @Autowired
    @Qualifier("codificador.bcrypt")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RepositorioUtilizadores repositorioUtilizadores;

    @PostMapping("/registar")
    public Utilizador registarUtilizador(@RequestBody Utilizador utilizador){
        try {
            utilizador.setPassword(bCryptPasswordEncoder.encode(utilizador.getPassword()));
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


}
