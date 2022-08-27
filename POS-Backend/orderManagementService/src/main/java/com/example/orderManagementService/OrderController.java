package com.example.orderManagementService;

import com.example.orderManagementService.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/id/{id}")
    public Order getEmployeeById(@PathVariable("id") int id){
        try {
            return orderService.getById(id);
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<Order> getAll(){
        try {
            return orderService.getAll();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping("/")
    public Order postEmployee(@RequestBody Order order){

        try {
            return orderService.postEmployee(order);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }


    @PostMapping("/bunch")
    public List<Order> postAllEmployee(@RequestBody List<Order> orders){
        try {
            return orderService.postEmployee(orders);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PutMapping("/")
    public Order putEmployee(@RequestBody Order order){

        try {
            return orderService.putEmployee(order);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
    @DeleteMapping("/{employeeId}")
    public Order deleteEmployee(@PathVariable int employeeId){
        try {
            return orderService.deleteEmployee(employeeId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }


}
