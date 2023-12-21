package com.ad.microservicoutilizadores;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class Utilizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    private String morada;
    private String email;
    private String password;

    private boolean disabled = false;

    //@Transient
    private String role;

    public Utilizador(String nome, String morada, String email, String password) {
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.password = password;
    }
}
