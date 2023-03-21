package com.cool.api.controller;

import com.cool.api.builder.InventoryBuilder;
import com.cool.api.dto.InventoryResponse;
import com.cool.domain.model.Inventory;
import com.cool.domain.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> findInventoryBySkuCodes (@RequestParam List<String> skuCodes){
        System.out.println("check inventory");
        List<Inventory> inventories = inventoryService.findInventoryBySkuCodes(skuCodes);

       return inventories.stream().map(inventory -> InventoryBuilder.buildInventoryResponse(inventory)).toList();
    }
    @GetMapping(path="/all")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> findAll (){
        List<Inventory> inventories = inventoryService.findAllInventory();
        return inventories.stream().map(inventory -> InventoryBuilder.buildInventoryResponse(inventory)).toList();
    }


}
