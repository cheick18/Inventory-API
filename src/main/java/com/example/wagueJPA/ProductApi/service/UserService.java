package com.example.wagueJPA.ProductApi.service;

import com.example.wagueJPA.ProductApi.dto.CategoryDTO;
import com.example.wagueJPA.ProductApi.dto.CategoryResponseDTO;
import com.example.wagueJPA.ProductApi.dto.UserDTO;
import com.example.wagueJPA.ProductApi.model.Category;
import com.example.wagueJPA.ProductApi.model.Users;
import com.example.wagueJPA.ProductApi.repository.UserRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserDTO convertToDto(Users user){
        return new UserDTO(user.getUserName(), user.getPassword());

    }
    public UserDTO createUser( UserDTO userdto) {
        Users newUser=new Users();
        newUser.setUserName(userdto.getUserName());
        newUser.setPassword(encoder.encode(userdto.getPassword()));
        Users savedUsers = userRepository.save(newUser);
        return convertToDto(savedUsers);

    }



}
