package com.ad.microservicoutilizadores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUtilizadores extends JpaRepository<Utilizador, Integer> {
}
