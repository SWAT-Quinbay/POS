package com.example.orderManagementService;

import com.example.orderManagementService.customException.PostgresException;
import com.example.orderManagementService.models.Order;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface OrderService {

    Order getById(int employeeId) throws PostgresException;

    List<Order> getAll();

    Order postEmployee(Order order);

    List<Order> postEmployee(List<Order> order);

    List<Order> postViaKufka(String datas) throws JsonProcessingException;

    Order putEmployee(Order employee) throws PostgresException;

    Order deleteEmployee(int employeeId) throws PostgresException;

}
