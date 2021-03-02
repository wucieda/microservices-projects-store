package com.ucieda.product.service;

import com.ucieda.product.dto.Product;
import com.ucieda.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addProduct(Product product) {
        productRepository.save(product);
        return "success";
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> productCategoryList(String category) {
        return productRepository.findByCategory(category);
    }

    public Product productById(Integer id) {
        return productRepository.findById(id).get();
    }

    public String updateProduct(Product product) {
        productRepository.save(product);
        return "product updated successfully";
    }

    public String deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return "product deleted";
    }
}
