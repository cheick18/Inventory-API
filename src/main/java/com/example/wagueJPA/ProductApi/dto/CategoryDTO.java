package com.example.wagueJPA.ProductApi.dto;

import jakarta.validation.constraints.NotNull;

public class CategoryDTO {

    @NotNull(message = "Category name can't be null")
    private String name;

    public CategoryDTO(@NotNull(message = "Category name can't be null") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
