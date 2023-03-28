package com.cool.api.controller;

import com.cool.api.builder.OrderBuilder;
import com.cool.api.dto.OrderRequest;
import com.cool.domain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    com.cool.product.app.OrderAppService orderAppService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        Order order = OrderBuilder.buildOrder(orderRequest);
        return  orderAppService.placeOrder(order);

    }
}
