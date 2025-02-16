package com.example.wagueJPA.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ott.InMemoryOneTimeTokenService;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return  http
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(authorizeRequests ->
                       authorizeRequests
                               .requestMatchers(HttpMethod.GET, "/api/categories","/api/categories/{id}", "/api/products","/api/products/{id}").permitAll()
                               .requestMatchers(HttpMethod.PUT, "/api/categories", "/api/products").authenticated()
                               .requestMatchers(HttpMethod.DELETE, "/api/categories", "/api/products").authenticated()
                               .anyRequest().authenticated()
               )
               .httpBasic(Customizer.withDefaults())
               .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))


        .build();


    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User
                .withDefaultPasswordEncoder()
                .username("cheickne")
                .password("c@11")
                .roles("USER")
                .build();
        UserDetails user2= User
                .withDefaultPasswordEncoder()
                .username("wague")
                .password("w@11")
                .roles("ADMIN")
                .build();
 return new InMemoryUserDetailsManager(user1,user2);

    }

}
