package com.cool.domain.service.impl;

import com.cool.domain.model.Order;
import com.cool.domain.repo.OrderRepo;
import com.cool.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Override
    public Order placeOrder(Order order) {
        return orderRepo.save(order);
    }
}
