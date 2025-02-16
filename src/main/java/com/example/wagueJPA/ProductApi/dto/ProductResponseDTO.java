package com.example.wagueJPA.ProductApi.dto;

public class ProductResponseDTO {


    private String name;
    private double price;
    private int quantity;
    private String categorieName;

    public ProductResponseDTO(String name, double price, int quantity, String categorieName) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categorieName = categorieName;
    }

    public ProductResponseDTO(String name, double price, int quantity) {

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductResponseDTO() {
    }

    public String getCategorieName() {
        return categorieName;
    }

    public void setCategorieName(String categorieName) {
        this.categorieName = categorieName;
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

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
