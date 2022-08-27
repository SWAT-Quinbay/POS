package com.example.orderManagementService.Kafka;


import com.example.orderManagementService.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class kafkaConsumer {

    @Autowired
    private OrderService orderService;
    @Autowired
    private Logger logger;

    @KafkaListener(topics="database",groupId="group_id")
    public void consume(String message){
        try {
            logger.info("Data Consumed BY dataBase "+ message);
            orderService.postViaKufka(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
