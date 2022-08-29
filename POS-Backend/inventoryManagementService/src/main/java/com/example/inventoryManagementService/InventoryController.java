package com.example.inventoryManagementService;

import com.example.inventoryManagementService.customExceptions.InvalidDataProvidedException;
import com.example.inventoryManagementService.customExceptions.NotEnoughQuanityException;
import com.example.inventoryManagementService.customExceptions.ProductNotFoundException;
import com.example.inventoryManagementService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;


    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        try {
            return inventoryService.getById(id);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
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
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/all")
    public Page<Product> getAll(@RequestParam int page, @RequestParam int size) {
        try {
            return inventoryService.getAll(page,size);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/add")
    public Product postProduct(@RequestBody Product product) {

        try {
            return inventoryService.postProduct(product);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


    @PostMapping("/add/all")
    public Iterable<Product> postAllProduct(@RequestBody List<Product> products) {
        try {
            return inventoryService.postProduct(products);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/stock/")
    public boolean checkProductStock(@RequestBody Product product){
        try {
            return inventoryService.checkStocks(product);
        }catch (ProductNotFoundException | NotEnoughQuanityException | InvalidDataProvidedException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/stock/all")
    public boolean checkProductStocks(@RequestBody List<Product> products){
        try {
            return inventoryService.checkStocks(products);
        }catch (ProductNotFoundException | NotEnoughQuanityException | InvalidDataProvidedException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/increment")
    public boolean incrementProductQuantity(@RequestBody Product product){
        try {
            return inventoryService.incrementQuantity(product);
        }catch (ProductNotFoundException | InvalidDataProvidedException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/increment/all")
    public boolean incrementProductsQuantity(@RequestBody List<Product> products){
        try {
            return inventoryService.incrementQuantity(products);
        }catch (ProductNotFoundException | InvalidDataProvidedException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/reduce")
    public boolean reduceQuantityProduct(@RequestBody Product product){
        try {
            return inventoryService.reduceQuantity(product);
        }catch (ProductNotFoundException | InvalidDataProvidedException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/reduce/all")
    public boolean reduceQuantityProducts(@RequestBody List<Product> products){
        try {
            return inventoryService.reduceQuantity(products);
        }catch (ProductNotFoundException | InvalidDataProvidedException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/")
    public Product putProduct(@RequestBody Product product) {

        try {
            return inventoryService.putProduct(product);
        }catch (ProductNotFoundException | InvalidDataProvidedException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/{productId}")
    public Product deleteProduct(@PathVariable int productId) {
        try {
            return inventoryService.deleteProduct(productId);
        }catch (ProductNotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


}
