package com.example.wagueJPA.ProductApi.service;

import com.example.wagueJPA.ProductApi.dto.CategoryDTO;
import com.example.wagueJPA.ProductApi.dto.CategoryResponseDTO;
import com.example.wagueJPA.ProductApi.exception.CategoryNotFoundException;
import com.example.wagueJPA.ProductApi.model.Category;
import com.example.wagueJPA.ProductApi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
@Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public CategoryResponseDTO convertToDto(Category category){
     return new CategoryResponseDTO(category.getName());

    }
    @Transactional
    public CategoryResponseDTO createCategory(@RequestBody CategoryDTO categoryDto) {
        Category category= new Category();
        category.setName(categoryDto.getName());

        Category savedCategory = categoryRepository.save(category);
     return convertToDto(savedCategory);
    }
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        return convertToDto(category);
    }
    @Transactional
    public void deleteCategory(Long id){
        Category existingCategory= categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
        categoryRepository.deleteById(id);
    }
    @Transactional
    public CategoryResponseDTO updateCategory(Long id, CategoryDTO categoryDTO){
        Category existingCategory= categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
        existingCategory.setName(categoryDTO.getName());
        Category updatedCategory = categoryRepository.save(existingCategory);
        return convertToDto(updatedCategory);
    }
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categries = categoryRepository.findAll();
        return categries.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    public Category savedCategory(CategoryDTO categoryDTO){
        Category category= new Category();
        category.setName(categoryDTO.getName());

        return categoryRepository.save(category);


    }
}
