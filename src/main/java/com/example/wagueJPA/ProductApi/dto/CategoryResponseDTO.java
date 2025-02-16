package com.example.wagueJPA.ProductApi.dto;

public class CategoryResponseDTO {
    private String name;

    public CategoryResponseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public CategoryResponseDTO(String name) {
        this.name = name;

    }
}
