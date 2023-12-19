package com.ad.microservicoutilizadores;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utilizador implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //TODO: nome must be unique
    private String nome;
    private String morada;
    private String email;
    private String password;
    private boolean disabled = false;

    public Utilizador(String nome, String morada, String email, String password) {
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (getUsername().equalsIgnoreCase("admin"))
            return Collections.<GrantedAuthority>singletonList(new
                    SimpleGrantedAuthority("ROLE_ADMIN"));
        else
            return Collections.<GrantedAuthority>singletonList(new
                    SimpleGrantedAuthority("ROLE_STANDARD"));
    }

    @Override
    public String getUsername() {
        return this.nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.disabled;
    }
}
