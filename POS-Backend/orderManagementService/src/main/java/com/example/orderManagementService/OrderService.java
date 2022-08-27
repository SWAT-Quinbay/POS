package com.example.orderManagementService;

import com.example.orderManagementService.customException.InvalidQuantityException;
import com.example.orderManagementService.customException.OrderAlreadyCanceledException;
import com.example.orderManagementService.customException.PostgresException;
import com.example.orderManagementService.models.Order;
import com.example.orderManagementService.utils.JsonOrder;
import com.example.orderManagementService.utils.InventoryProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    Order getById(int orderId) throws PostgresException;

    Page<Order> getAll(int page, int size);

    Order postOrder(JsonOrder order) throws PostgresException, InvalidQuantityException;

    List<Order> postOrder(List<JsonOrder> order) throws PostgresException, InvalidQuantityException;

    void updateInventoryViaKafka(List<InventoryProduct> orderItems) throws JsonProcessingException;

    Order cancelOrder(int orderId) throws PostgresException, JsonProcessingException, OrderAlreadyCanceledException;

}
