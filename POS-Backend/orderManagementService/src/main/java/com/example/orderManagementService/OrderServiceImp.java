package com.example.orderManagementService;

import com.example.orderManagementService.customException.PostgresException;
import com.example.orderManagementService.models.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Logger logger;

    @Override
    public Order getById(int employeeId) throws PostgresException {

        Optional<Order> employee  = orderRepository.findById(employeeId);

        if(employee.isPresent()){
            return employee.get();
        }

        throw new PostgresException("Invalid Order Id");
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();

    }

    @Override
    public Order postEmployee(Order order) {
            order = orderRepository.save(order);
            return order;
    }
@Override
    public List<Order> postEmployee(List<Order> orders) {
        return orderRepository.saveAll(orders);
    }

    @Override
    public List<Order> postViaKufka(String datas) throws JsonProcessingException {
        TypeReference<List<Order>> ref = new TypeReference<List<Order>>(){};
        return postEmployee(objectMapper.readValue(datas,ref));
    }


    @Override
    public Order putEmployee(Order order) throws PostgresException {

        Order modifiedOrder = getById(order.getId());

        modifiedOrder.setId(order.getId());
        modifiedOrder.setName(order.getName());
        modifiedOrder.setDesignation(order.getDesignation());
        modifiedOrder.setSalary(order.getSalary());
        modifiedOrder.setExperience(order.getExperience());

        return orderRepository.save(modifiedOrder);
    }

    @Override
    public Order deleteEmployee(int employeeId) throws PostgresException {

        Order order = getById(employeeId);

        orderRepository.deleteById(employeeId);

        return order;
    }
}
