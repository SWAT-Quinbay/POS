package com.example.inventoryManagementService;

import com.example.inventoryManagementService.customExceptions.InvalidDataProvidedException;
import com.example.inventoryManagementService.customExceptions.NotEnoughQuanityException;
import com.example.inventoryManagementService.customExceptions.PostgresException;
import com.example.inventoryManagementService.customExceptions.ProductNotFoundException;
import com.example.inventoryManagementService.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface InventoryService {

    Product getById(int productId) throws PostgresException;

    List<Product> getByName(String name);

    List<Product> searchByName(String query);

    List<Product> getAll();

    Product postProduct(Product product);

    List<Product> postProduct(List<Product> product);

    List<Product> incrementQuantityViaKafka(String data)
            throws JsonProcessingException, ProductNotFoundException, NotEnoughQuanityException;

    boolean incrementQuantity(Product product) throws ProductNotFoundException, NotEnoughQuanityException;
    boolean incrementQuantity(List<Product> product) throws ProductNotFoundException, NotEnoughQuanityException;

    boolean reduceQuantity(Product product) throws ProductNotFoundException, NotEnoughQuanityException;
    boolean reduceQuantity(List<Product> product) throws ProductNotFoundException, NotEnoughQuanityException;

    Product putProduct(Product product) throws PostgresException, InvalidDataProvidedException;

    Product deleteEmployee(int employeeId) throws PostgresException;

}
