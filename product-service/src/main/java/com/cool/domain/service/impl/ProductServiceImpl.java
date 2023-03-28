package com.cool.domain.service.impl;

import com.cool.domain.service.ProductService;
import com.cool.domain.model.Product;
import com.cool.domain.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Optional<Product> findBySkuCode(String skuCode) {
      return  productRepo.findBySkuCode(skuCode);
    }
}
