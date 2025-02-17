package com.example.wagueJPA.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
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
   public AuthenticationProvider authenticationProvider(){
       DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
       provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
       provider.setUserDetailsService(userDetailsService);
       return provider;
   }

}
