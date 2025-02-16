package com.example.wagueJPA.ProductApi.Controller;

import com.example.wagueJPA.ProductApi.dto.CategoryDTO;
import com.example.wagueJPA.ProductApi.dto.CategoryResponseDTO;
import com.example.wagueJPA.ProductApi.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CategoryController {
   private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/api/categories")
    public ResponseEntity<CategoryResponseDTO> createCategorie(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryResponseDTO savedCategory = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(savedCategory);
    }
    @GetMapping("/api/categories/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {
      CategoryResponseDTO category=categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/api/categories")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    @DeleteMapping("/api/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/api/categories/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO){
        CategoryResponseDTO updateCategory= categoryService.updateCategory(id,categoryDTO);
        return  new ResponseEntity<>(updateCategory,HttpStatus.OK);
    }


}
