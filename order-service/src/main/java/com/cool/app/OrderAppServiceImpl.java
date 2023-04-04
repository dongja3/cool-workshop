package com.cool.notification.app;

import com.cool.api.dto.InventoryResponse;
import com.cool.domain.event.OrderEvent;
import com.cool.domain.model.Order;
import com.cool.domain.model.OrderLineItem;
import com.cool.domain.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class OrderAppServiceImpl implements com.cool.product.app.OrderAppService {

    @Autowired
    OrderService orderService;

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public String placeOrder(Order order) {
        log.info("start place order{}", order.getOrderNo());

        List<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItem::getSkuCode).toList();

        for(String skuCode: skuCodes){
            boolean isProductExist = webClientBuilder.build().get().uri("http://product-service",
                    uriBuilder -> uriBuilder.path("/api/product/exist/{skuCode}")
                            .build(skuCode)).retrieve().bodyToMono(Boolean.class).block();
            if(!isProductExist){
                return "No such product";
            }
        }

        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);

        if(allProductsInStock){
            log.info("end place order{}", order.getOrderNo());
            Order order1 = orderService.placeOrder(order);
            rabbitTemplate.convertAndSend("order-queue", OrderEvent.builder().orderNo(order1.getOrderNo()).build());
            return "Order Placed Successfully";
        }else{
            return "Product is not in stock, please try again later";
        }
        
    }
}
