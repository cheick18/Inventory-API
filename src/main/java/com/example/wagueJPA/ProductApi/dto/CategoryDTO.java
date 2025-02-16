package com.example.wagueJPA.ProductApi.dto;

import jakarta.validation.constraints.NotNull;

public class CategoryDTO {
    private Long id;
    @NotNull(message = "Category name can't be null")
    private String name;

    public CategoryDTO(String name) {

        this.name = name;
    }

    public CategoryDTO() {
    }


    public CategoryDTO(Long id, @NotNull(message = "Category name can't be null") String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
