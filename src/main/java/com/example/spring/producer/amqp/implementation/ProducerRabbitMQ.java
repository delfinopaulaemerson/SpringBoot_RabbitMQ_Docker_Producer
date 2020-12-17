package com.example.spring.producer.amqp.implementation;

import com.example.spring.producer.amqp.AmqpProducer;
import com.example.spring.producer.dto.Message;
import org.springframework.amqp.AmqpApplicationContextClosedException;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMQ implements AmqpProducer<Message> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchanche;

    @Override
    public void producer(Message message) {
        try {
            rabbitTemplate.convertAndSend(exchanche, queue, message);
        }catch (Exception e){
            throw new AmqpRejectAndDontRequeueException(e);
        }

    }
}
