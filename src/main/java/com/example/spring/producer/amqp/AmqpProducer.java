package com.example.spring.producer.amqp;

public interface AmqpProducer<T> {

    public void producer(T t);
}
