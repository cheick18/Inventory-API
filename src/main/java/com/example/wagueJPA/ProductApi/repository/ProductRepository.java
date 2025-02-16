package com.example.wagueJPA.ProductApi.repository;

import com.example.wagueJPA.ProductApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
