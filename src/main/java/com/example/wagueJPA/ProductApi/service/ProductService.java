package com.example.wagueJPA.ProductApi.service;

import com.example.wagueJPA.ProductApi.dto.ProductResponseDTO;
import com.example.wagueJPA.ProductApi.dto.ProductDTO;
import com.example.wagueJPA.ProductApi.exception.ProductNotFoundException;
import com.example.wagueJPA.ProductApi.model.Category;
import com.example.wagueJPA.ProductApi.model.Product;
import com.example.wagueJPA.ProductApi.repository.CategoryRepository;
import com.example.wagueJPA.ProductApi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
//convert product to responseDTO
    public ProductResponseDTO convertToDto(Product product){
        return new ProductResponseDTO(product.getName(),product.getPrice(), product.getQuantity(), product.getCategorie().getName());
    }
    //Create product
    @Transactional
    public ProductResponseDTO createProduct( ProductDTO productDTO) {
        Category category =categoryRepository.findById(productDTO.getCategorieId())
                .orElseThrow(() -> new RuntimeException("Catégorie not found"));

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategorie(category);
        Product savedProduct = productRepository.save(product);
        return convertToDto(savedProduct);
    }
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return convertToDto(product);
    }
    // update product
    @Transactional
    public ProductResponseDTO updateProduct(Long id, ProductDTO productDTO){
        Product existingProduct= productRepository.findById(id).orElseThrow(()->new ProductNotFoundException(id));
        existingProduct.setName(productDTO.getName());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setQuantity(productDTO.getQuantity());
        Product updatedProduct = productRepository.save(existingProduct);
        return convertToDto(existingProduct);
    }
    @Transactional
    public void deleteProduct(Long id){
        Product existingProduct= productRepository.findById(id).orElseThrow(()->new ProductNotFoundException(id));
        productRepository.deleteById(id);
    }
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
