package com.example.wagueJPA.ProductApi.Controller;


import com.example.wagueJPA.ProductApi.dto.UserDTO;
import com.example.wagueJPA.ProductApi.model.Users;
import com.example.wagueJPA.ProductApi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/api/users")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.createUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }
}
