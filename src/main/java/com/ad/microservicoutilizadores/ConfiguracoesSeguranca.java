package com.ad.microservicoutilizadores;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class ConfiguracoesSeguranca {

    /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((autorizacao) -> autorizacao
                        .requestMatchers("/", "/formregistar", "/registar").permitAll()
                        .requestMatchers("/listar", "/remover/**", "/editar/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/mvc/contas/**").hasAnyRole("ADMIN", "STANDARD")
                        .requestMatchers("/mvc/admin/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                //.anyRequest().denyAll())
                .formLogin((login) -> login
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/mvc/contas/titular"))
                .logout((logout)->logout
                        .logoutUrl("/logout").permitAll()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .invalidateHttpSession(true))
                .exceptionHandling((accessonegado)->accessonegado
                        .accessDeniedPage("/acesso-negado"))
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    /**
     @Bean
     public UserDetailsService userDetailsService(){

     UserDetails utilizador = User.builder()
     .username("utilizador")
     .password(getCodificadorPassword().encode("123456"))
     .roles("STANDARD")
     .build();

     UserDetails admin = User.builder()
     .username("admin")
     .password(getCodificadorPassword().encode("admin"))
     .roles("ADMIN")
     .build();

     return new InMemoryUserDetailsManager(utilizador, admin);
     }
     */
    @Bean("codificador.bcrypt")
    public BCryptPasswordEncoder getCodificadorPassword(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager
    authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }
}