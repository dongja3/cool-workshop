package com.cool.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    private String skuCode;
    private Integer quantity;
    public boolean isInStock(){
        return quantity>0;
    }
}
