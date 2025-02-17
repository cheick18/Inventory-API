package com.example.wagueJPA.ProductApi.dto;

import jakarta.validation.constraints.NotNull;

public class UserDTO {
    @NotNull(message = "User name can't be null")
    private String username;
    @NotNull(message = "User password can't be null")
    private String password;

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
