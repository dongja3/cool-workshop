package com.cool.api.controller;

import com.cool.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @RequestMapping(path="/exist/{skuCode}")
    @ResponseStatus (HttpStatus.OK)
    boolean findBySkuCode(@PathVariable String skuCode){

        return productService.findBySkuCode(skuCode).isPresent();
    }
}
