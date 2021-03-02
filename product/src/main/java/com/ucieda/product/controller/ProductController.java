package com.ucieda.product.controller;

import com.ucieda.product.dto.Product;
import com.ucieda.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/v1")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        String status = productService.addProduct(product);
        log.info("Product added status - {}", status);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/productList")
    public List<Product> productList() {
        return productService.listAllProducts();
    }

    @GetMapping("/productList/{category}")
    public List<Product> productCategoryList(@PathVariable String category) {
        return productService.productCategoryList(category);
    }

    @GetMapping("/product/{id}")
    public Product productById(@PathVariable Integer id) {
        return productService.productById(id);
    }

    @PutMapping("/productUpdate")
    public String updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProductById(@PathVariable Integer id) {
        return productService.deleteProductById(id);
    }
}
