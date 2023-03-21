package com.cool.domain.service;

import com.cool.domain.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> findBySkuCode(String skuCode);
}
