package com.cool;

import com.cool.domain.model.Product;
import com.cool.domain.repo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(ProductRepo productRepo){
        return  args -> {
            productRepo.deleteAll();
            Product product0 =Product.builder().name("iPhone 13").skuCode("iphone_13").description("iPhone 13").price(BigDecimal.valueOf(6000)).build();
            Product product1 =Product.builder().name("iPhone 14").skuCode("iphone_14").description("iPhone 14").price(BigDecimal.valueOf(8000)).build();
            productRepo.save(product0);
            productRepo.save(product1);
        };
    }
}

