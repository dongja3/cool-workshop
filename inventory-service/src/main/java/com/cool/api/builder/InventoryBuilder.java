package com.cool.api.builder;

import com.cool.api.dto.InventoryResponse;
import com.cool.domain.model.Inventory;


public class InventoryBuilder {
    public static InventoryResponse buildInventoryResponse(Inventory inventory){
        return  InventoryResponse.builder().skuCode(inventory.getSkuCode())
                .quantity(inventory.getQuantity()).build();
    }
}
