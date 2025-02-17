package com.example.wagueJPA.configuration;

import com.example.wagueJPA.ProductApi.dto.CategoryDTO;
import com.example.wagueJPA.ProductApi.dto.ProductDTO;
import com.example.wagueJPA.ProductApi.dto.UserDTO;
import com.example.wagueJPA.ProductApi.model.Category;
import com.example.wagueJPA.ProductApi.model.Product;
import com.example.wagueJPA.ProductApi.model.Users;
import com.example.wagueJPA.ProductApi.service.CategoryService;
import com.example.wagueJPA.ProductApi.service.ProductService;
import com.example.wagueJPA.ProductApi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class TestApplication {
    private static final Logger log = LoggerFactory.getLogger(TestApplication.class);
    List<Category> categoryList= new ArrayList<>();

   public Long getRandomCategory() {
       Random random = new Random();
       int index=random.nextInt(categoryList.size());
       return categoryList.get(index).getId();
   }

    @Bean
    CommandLineRunner initDatabase(ProductService productService, CategoryService categoryService, UserService userService){
        return args -> {

            CategoryDTO[] savedcategories[];
            CategoryDTO[] categories = {
                    new CategoryDTO( "Electronique"),
                    new CategoryDTO("Vêtements"),
                    new CategoryDTO("Accessoires"),
                    new CategoryDTO("Maison"),
                    new CategoryDTO("Sport"),
                    new CategoryDTO("Jouets"),
                    new CategoryDTO("Alimentation"),

            };

            for ( CategoryDTO categoryDTO : categories) {
                categoryList.add(categoryService.savedCategory(categoryDTO));
                // log.info("Preloading " + categoryService.createCategory(categoryDTO));
            }

            ProductDTO[] products = {

                    new ProductDTO("Jeans", 49.99, 30, getRandomCategory()),
                    new ProductDTO("Sneakers", 69.99, 20, getRandomCategory()),
                    new ProductDTO("Jacket", 99.99, 15, getRandomCategory()),
                    new ProductDTO("Watch", 199.99, 10, getRandomCategory()),
                    new ProductDTO("Laptop", 899.99, 5, getRandomCategory()),
                    new ProductDTO("Phone", 499.99, 25, getRandomCategory()),
                    new ProductDTO("Headphones", 79.99, 40, getRandomCategory()),
                    new ProductDTO("Backpack", 39.99, 60, getRandomCategory()),
                    new ProductDTO( "Sunglasses", 29.99, 100, getRandomCategory())
            };


            for (ProductDTO productDTO : products) {
                log.info("Preloading " + productService.createProduct(productDTO));
            }
            UserDTO users[]={
                    new UserDTO("wague","w@11"),
                    new UserDTO("cheick","c@11")
     };
            for (UserDTO userDTO : users) {
                log.info("Preloading " + userService.createUser(userDTO));
            }


        };

    }
}
