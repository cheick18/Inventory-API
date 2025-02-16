package com.example.wagueJPA.ProductApi.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reference;
    private String name;
    private double price;


    private int quantity;

    public Category getCategorie() {
        return categorie;
    }

    public void setCategorie(Category categorie) {
        this.categorie = categorie;
    }

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Category categorie;

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
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

    public int getQuantity(int quantity) {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Double.compare(product.price, price) == 0 && quantity == product.quantity && Objects.equals(reference, product.reference) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, name, price, quantity);
    }
}
