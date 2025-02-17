package com.example.wagueJPA.ProductApi.Controller;

import com.example.wagueJPA.ProductApi.dto.ProductDTO;
import com.example.wagueJPA.ProductApi.dto.ProductResponseDTO;
import com.example.wagueJPA.ProductApi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {

        return ResponseEntity.ok(productService.getAllProducts());
    }
    @PostMapping("")
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){
        ProductResponseDTO createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.ok(createdProduct);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO){
        ProductResponseDTO updateProduct = productService.updateProduct(id,productDTO);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id){
        return  new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);

    }
}
