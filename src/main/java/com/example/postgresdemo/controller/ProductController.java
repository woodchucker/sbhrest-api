package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Product;
import com.example.postgresdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/product/read")
 //   public Page<Product> getProducts(Pageable pageable) {
 //       return productRepository.findAll(pageable);
 //   }
    @ResponseBody
    public List<Product> getProducts() {
       return productRepository.findAll();
    }
    @GetMapping("/api/product/read/{product_id}")
    @ResponseBody
    public Optional<Product> getProductById(@PathVariable Long product_id) {
        return productRepository.findById(product_id);
    }

    @PostMapping("/api/product/create")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/api/product/update")
    public Product updateProduct( @Valid @RequestBody Product productBody) {
        Long productId = productBody.getproduct_id();
        return productRepository.findById(productId)
                .map(product -> {
                    product.setproduct_name(productBody.getproduct_name());
                    product.setdescription(productBody.getdescription());
                    product.setprice(productBody.getprice());
                    product.setdescription(productBody.getdescription());
                    product.setduration_days(productBody.getduration_days());
                    product.setlocked_at(productBody.getlocked_at());
                    product.setunlocked_at(productBody.getunlocked_at());
                    return productRepository.save(product);
                }).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productBody.getproduct_id()));
    }

    @DeleteMapping("/api/product/delete/{product_id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long product_id) {
        return productRepository.findById(product_id)
        .map(product -> {
            productRepository.delete(product);
            
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + product_id));      
    }
}