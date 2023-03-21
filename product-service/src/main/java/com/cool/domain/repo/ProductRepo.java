package com.cool.domain.repo;

import com.cool.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepo extends MongoRepository<Product,String> {
    Optional<Product> findBySkuCode(String skuCode);
}
