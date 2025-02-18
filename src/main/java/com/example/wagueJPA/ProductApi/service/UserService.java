package com.example.wagueJPA.ProductApi.service;

import com.example.wagueJPA.ProductApi.dto.UserDTO;
import com.example.wagueJPA.ProductApi.model.Users;
import com.example.wagueJPA.ProductApi.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserService {
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }
    public UserDTO convertToDto(Users user){
        return new UserDTO(user.getUserName(), user.getPassword());

    }
    public boolean verifyUser(UserDTO userDTO) {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getUserName(), userDTO.getPassword())
            );

            return authentication.isAuthenticated();
    }

    public UserDTO createUser( UserDTO userdto) {
        Users newUser=new Users();
        newUser.setUserName(userdto.getUserName());
        newUser.setPassword(encoder.encode(userdto.getPassword()));
        Users savedUsers = userRepository.save(newUser);
        return convertToDto(savedUsers);

    }

    public boolean login (UserDTO userdto){

       return verifyUser(userdto) ;



    }
    public List<Users> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream()

                .collect(Collectors.toList());
    }




}
