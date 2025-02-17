package com.example.wagueJPA.ProductApi.dto;

import com.example.wagueJPA.ProductApi.model.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductDTO {
    @NotNull(message = "Name can't be nul")
    private String name;
    @NotNull(message = "Price can't be null")
    @DecimalMin(value = "0.01", message = "Le price shoul be supperior to 0")
    private double price;

    @Min(value = 0, message = "Quantity shoud be positve or null")
    private int quantity;
    @NotNull(message = "Product categorie is reuired")
    private Long categorieId;

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }

    public ProductDTO(@NotNull(message = "Name can't be nul") String name, @NotNull(message = "Price can't be null") double price, int quantity, @NotNull(message = "Product categorie is reuired") Long categorieId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categorieId = categorieId;
    }
}
