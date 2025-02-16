package com.example.wagueJPA.ProductApi.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "categorie")
    private List<Product> produits;

    public Category() {
    }

    public Category(Long id, String name, List<Product> produits) {
        this.id = id;
        this.name = name;
        this.produits = produits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduits() {
        return produits;
    }

    public void setProduits(List<Product> produits) {
        this.produits = produits;
    }
}
