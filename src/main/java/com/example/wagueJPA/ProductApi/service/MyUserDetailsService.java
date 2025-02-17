package com.example.wagueJPA.ProductApi.service;

import com.example.wagueJPA.ProductApi.model.UserPrincipal;
import com.example.wagueJPA.ProductApi.model.Users;
import com.example.wagueJPA.ProductApi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user= userRepository.findByUserName(username);
        if(user==null) throw new UsernameNotFoundException("user not found");
        return new UserPrincipal(user);
    }
}
