package com.cool.domain.service;

import com.cool.domain.model.Inventory;

import java.util.List;

public interface InventoryService {

     List<Inventory> findInventoryBySkuCodes(List<String> skuCodes);

     List<Inventory> findAllInventory();
}
