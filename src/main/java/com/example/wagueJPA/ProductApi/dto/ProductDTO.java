package com.example.wagueJPA.ProductApi.dto;

import com.example.wagueJPA.ProductApi.model.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductDTO {
    @NotNull(message = "Reference can't be null")
    @Positive(message = "Reference should be positif")
    private Long reference;
    @NotNull(message = "Name can't be nul")
    private String name;
    @NotNull(message = "Price can't be null")
    @DecimalMin(value = "0.01", message = "Le price shoul be supperior to 0")
    private double price;

    @Min(value = 0, message = "Quantity shoud be positve or null")
    private int quantity;
    @NotNull(message = "Product categorie is reuired")
    private Category categorie;

    public ProductDTO(@NotNull(message = "Reference can't be null") Long reference, @NotNull(message = "Name can't be nul") String name, @NotNull(message = "Price can't be null") double price, int quantity, @NotNull(message = "Product categorie is reuired") Category categorie) {
        this.reference = reference;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categorie = categorie;
    }

    public Long getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductDTO(Long reference, String name, double price, int quantity) {
        this.reference = reference;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public Category getCategorie() {
        return categorie;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
