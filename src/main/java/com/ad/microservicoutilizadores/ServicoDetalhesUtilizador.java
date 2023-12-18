package com.ad.microservicoutilizadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServicoDetalhesUtilizador implements UserDetailsService {

    @Autowired
    private RepositorioUtilizadores repositorioUtilizadores;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositorioUtilizadores
                .findByNome(username)
                .orElseThrow(()->new UsernameNotFoundException("Utilizador Inválido"));
    }
}
