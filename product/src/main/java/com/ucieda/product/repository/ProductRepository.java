package com.ucieda.product.repository;

import com.ucieda.product.dto.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
    @Query("{'Category.name':?0}")
    List<Product> findByCategory(String category);
}
