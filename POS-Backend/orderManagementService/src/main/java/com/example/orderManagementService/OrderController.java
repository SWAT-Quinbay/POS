package com.example.orderManagementService;

import com.example.orderManagementService.models.Order;
import com.example.orderManagementService.utils.JsonOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping("/all")
    public Page<Order> getAll(@RequestParam int page,@RequestParam int size){
        try {
            return orderService.getAll(page,size);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public Order getOrderById(@PathVariable("id") int id){

        try {
            return orderService.getById(id);
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

    }


    @PostMapping("/add")
    public Order postOrder(@RequestBody JsonOrder jsonOrder){

        try {
            return orderService.postOrder(jsonOrder);
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

    }


    @PostMapping("/add/all")
    public List<Order> postAllOrder(@RequestBody List<JsonOrder> orders){
        try {
            return orderService.postOrder(orders);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }


    @GetMapping("/cancel/{orderId}")
    public Order cancelOrder(@PathVariable int orderId){
        try {
            return orderService.cancelOrder(orderId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }


}
