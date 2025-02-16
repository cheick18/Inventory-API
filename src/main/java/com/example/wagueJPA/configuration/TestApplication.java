package com.example.wagueJPA.configuration;

import com.example.wagueJPA.ProductApi.dto.CategoryDTO;
import com.example.wagueJPA.ProductApi.dto.ProductDTO;
import com.example.wagueJPA.ProductApi.model.Category;
import com.example.wagueJPA.ProductApi.service.CategoryService;
import com.example.wagueJPA.ProductApi.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class TestApplication {
    private static final Logger log = LoggerFactory.getLogger(TestApplication.class);
    public Category getRandomCategory(CategoryDTO[] categories) {
        Random random = new Random();
         CategoryDTO categoryDTO=  categories[random.nextInt(categories.length)];
         Category category= new Category();
         category.setName(categoryDTO.getName());
         category.setId(categoryDTO.getId());
         return category;
    }
    @Bean
    CommandLineRunner initDatabase(ProductService productService, CategoryService categoryService){
        return args -> {

            CategoryDTO[] categories = {
                    new CategoryDTO( 1L,"Electronique"),
                    new CategoryDTO(2L,"Vêtements"),
                    new CategoryDTO(3L,"Accessoires"),
                    new CategoryDTO(4L,"Maison"),
                    new CategoryDTO(5L,"Sport"),
                    new CategoryDTO(6L,"Jouets"),
                    new CategoryDTO(7L,"Alimentation"),

            };

            for ( CategoryDTO categoryDTO : categories) {
                log.info("Preloading " + categoryService.createCategory(categoryDTO));
            }

            ProductDTO[] products = {
                    new ProductDTO(1L, "T-shirt", 19.99, 50, getRandomCategory(categories)),
                    new ProductDTO(2L, "Jeans", 49.99, 30, getRandomCategory(categories)),
                    new ProductDTO(3L, "Sneakers", 69.99, 20, getRandomCategory(categories)),
                    new ProductDTO(4L, "Jacket", 99.99, 15, getRandomCategory(categories)),
                    new ProductDTO(5L, "Watch", 199.99, 10, getRandomCategory(categories)),
                    new ProductDTO(6L, "Laptop", 899.99, 5, getRandomCategory(categories)),
                    new ProductDTO(7L, "Phone", 499.99, 25, getRandomCategory(categories)),
                    new ProductDTO(8L, "Headphones", 79.99, 40, getRandomCategory(categories)),
                    new ProductDTO(9L, "Backpack", 39.99, 60, getRandomCategory(categories)),
                    new ProductDTO(10L, "Sunglasses", 29.99, 100, getRandomCategory(categories))
            };

            for (ProductDTO productDTO : products) {
                log.info("Preloading " + productService.createProduct(productDTO));
            }

        };

    }
}
