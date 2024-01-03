package com.ad.microservicoutilizadores;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioUtilizadores extends JpaRepository<Utilizador, Integer> {
    public Optional<Utilizador> findByNome(String nome);

    public List<Utilizador> findAllBy();

    /*@Modifying
    @Transactional
    @Query("Delete From Utilizador u WHERE u.id = :id")
    public void deleteUtilizadorById(@PathVariable("id") Integer id);
    */

    @Transactional
    public void deleteById(@PathVariable Integer id);
}
