package com.ad.microservicoutilizadores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioUtilizadores extends JpaRepository<Utilizador, Integer> {
    public Optional<Utilizador> findByNome(String nome);

    public Optional<Utilizador> findByNomeAndPassword(String nome, String password);

}
