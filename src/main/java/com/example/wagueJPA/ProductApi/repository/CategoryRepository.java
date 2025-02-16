package com.example.wagueJPA.ProductApi.repository;

import com.example.wagueJPA.ProductApi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
