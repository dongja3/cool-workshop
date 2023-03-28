package com.cool.service.impl;

import com.cool.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServiceImpl  implements NotificationService {
    @Override
    @RabbitListener(queues = "order-queue", concurrency = "5")
    public void processOrder(Message message) {
        log.info("Received order:" +message.toString());
    }
}
