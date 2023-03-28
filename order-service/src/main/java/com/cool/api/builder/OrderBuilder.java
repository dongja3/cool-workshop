package com.cool.api.builder;

import com.cool.api.dto.OrderRequest;
import com.cool.api.dto.OrderRequestItem;
import com.cool.domain.model.Order;
import com.cool.domain.model.OrderLineItem;

import java.util.List;
import java.util.UUID;

public class OrderBuilder {
    public static Order buildOrder(OrderRequest orderRequest) {
        List<OrderLineItem> orderLineItems = orderRequest.getOrderRequestItems().stream()
                .map(requestItem -> buildOrderLineItem(requestItem)).toList();
        return Order.builder().orderNo(UUID.randomUUID().toString())
                .orderLineItems(orderLineItems).build();
    }

    private  static OrderLineItem buildOrderLineItem(OrderRequestItem requestItem){
        return OrderLineItem.builder()
                .skuCode(requestItem.getSkuCode())
                .price(requestItem.getPrice())
                .quantity(requestItem.getQuantity()).build();
    }
}
