package com.example.spring.producer.service;

import com.example.spring.producer.dto.Message;

public interface AmqpService {

    public void sendToConsumer(Message message);
}
