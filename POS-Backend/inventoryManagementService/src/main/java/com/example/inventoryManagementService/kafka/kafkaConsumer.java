package com.example.inventoryManagementService.kafka;

import com.example.inventoryManagementService.InventoryService;
import com.example.inventoryManagementService.customExceptions.NotEnoughQuanityException;
import com.example.inventoryManagementService.customExceptions.ProductNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class kafkaConsumer {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private Logger logger;


    @KafkaListener(topics="updateInventory", groupId = "group-1")
    public void consume(String message){
        try {
            logger.info("Data Consumed BY dataBase "+ message);
            inventoryService.incrementQuantityViaKafka(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
