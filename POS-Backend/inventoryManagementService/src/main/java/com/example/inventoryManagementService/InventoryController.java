package com.example.inventoryManagementService;

import com.example.inventoryManagementService.customExceptions.ProductNotFoundException;
import com.example.inventoryManagementService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;


    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        try {
            return inventoryService.getById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductByName(@PathVariable("name") String name) {
        try {
            return inventoryService.getByName(name);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    
    @GetMapping("/search")
    public List<Product> searchProductByName(@RequestParam String name) {
        try {
            return inventoryService.searchByName(name);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        try {
            return inventoryService.getAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/")
    public Product postProduct(@RequestBody Product employee) {

        try {
            return inventoryService.postProduct(employee);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @PostMapping("/bunch")
    public List<Product> postAllProduct(@RequestBody List<Product> employees) {
        try {
            return inventoryService.postProduct(employees);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/increment")
    public boolean incrementProductQuantity(@RequestBody Product product){
        try {
            return inventoryService.incrementQuantity(product);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/increment/all")
    public boolean incrementProductsQuantity(@RequestBody List<Product> products){
        try {
            return inventoryService.incrementQuantity(products);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/reduce")
    public boolean reduceQuantityProduct(@RequestBody Product product){
        try {
            return inventoryService.reduceQuantity(product);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/reduce/all")
    public boolean reduceQuantityProducts(@RequestBody List<Product> products){
        try {
            return inventoryService.reduceQuantity(products);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/")
    public Product putProduct(@RequestBody Product product) {

        try {
            return inventoryService.putProduct(product);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{productId}")
    public Product deleteProduct(@PathVariable int productId) {
        try {
            return inventoryService.deleteEmployee(productId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
