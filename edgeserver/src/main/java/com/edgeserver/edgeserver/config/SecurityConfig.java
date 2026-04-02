package com.edgeserver.edgeserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*@Bean
    SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {*//*
        http
                .csrf(csrf -> csrf.disable()).
                        authorizeExchange(exchange -> exchange
                               // .pathMatchers("/headerrouting/**").permitAll()
                                .pathMatchers("/actuator/**").permitAll()
                                .pathMatchers("/eureka/**").permitAll()
                                .pathMatchers("/oauth2/**").permitAll()
                                .pathMatchers("/login/**").permitAll()
                                .pathMatchers("/error/**").permitAll()
                              //  .pathMatchers("/openapi/**").permitAll()
                                .anyExchange().authenticated()))
                .oauth2ResourceServer(server -> server
                        .jwt(Customizer.withDefaults()));
        return http.build();*//*
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        requests -> requests.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();

    }*/
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/actuator/**").permitAll()
                        .requestMatchers("/eureka/**").permitAll()
                        .requestMatchers("/oauth2/**").permitAll()
                        .requestMatchers("/login/**").permitAll()
                        .requestMatchers("/error/**").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(server -> server
                .jwt(Customizer.withDefaults()));
                /*.oauth2Login(oauth -> oauth
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
        );*/


        return http.build();
    }
}
