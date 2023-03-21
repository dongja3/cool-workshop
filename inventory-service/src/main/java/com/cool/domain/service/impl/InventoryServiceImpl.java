package com.cool.domain.service.impl;


import com.cool.domain.model.Inventory;
import com.cool.domain.repo.InventoryRepo;
import com.cool.domain.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;
    @Override
    public List<Inventory> findInventoryBySkuCodes(List<String> skuCodes) {
        return inventoryRepo.findBySkuCodeIn(skuCodes);
    }

    @Override
    public List<Inventory> findAllInventory() {
        return inventoryRepo.findAll();
    }
}
