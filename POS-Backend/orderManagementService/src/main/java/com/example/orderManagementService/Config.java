package com.example.orderManagementService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Logger getLogger(){
        return LoggerFactory.getLogger(OrderManagementServiceApplication.class);
    }

}