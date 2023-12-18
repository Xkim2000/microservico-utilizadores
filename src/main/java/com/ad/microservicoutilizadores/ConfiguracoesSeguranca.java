package com.ad.microservicoutilizadores;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
//@EnableWebSecurity
public class ConfiguracoesSeguranca {
    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {//(2)
        http.authorizeHttpRequests((autorizacao) -> autorizacao
                        .requestMatchers("/", "formregistar", "/registar").permitAll()
                        .requestMatchers("listar","/remover/**","/editar/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/mvc/contas/**").hasAnyRole("ADMIN","STANDARD")
                        .requestMatchers("/mvc/admin/**").hasRole("ADMIN")
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
/*
    @Bean
    public UserDetailsService userDetailsService(){
        //List<UserDetails> listUsers = new ArrayList<>();

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

        //listUsers.add(admin);
        //listUsers.add(utilizador);
        
        return new InMemoryUserDetailsManager(utilizador,admin);
    }
*/


    /*
    @Bean
    public AuthenticationManager
    authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }*/


    @Bean("codificador.bcrypt")
    public BCryptPasswordEncoder getCodificadorPassword(){
        return new BCryptPasswordEncoder();
    }

}
