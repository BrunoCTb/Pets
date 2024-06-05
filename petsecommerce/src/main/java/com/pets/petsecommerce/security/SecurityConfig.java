package com.pets.petsecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(c -> c.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/css/**", "/js/**", "/pictures/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/", "/index", "/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/register").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(f -> f
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .logout(l -> l.permitAll());

        return http.build();
    }
}
