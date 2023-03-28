package com.cool.service;

import org.springframework.amqp.core.Message;

public interface NotificationService {
    void processOrder(Message message);
}
