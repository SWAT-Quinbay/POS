package com.example.inventoryManagementService;

import com.example.inventoryManagementService.customExceptions.InvalidDataProvidedException;
import com.example.inventoryManagementService.customExceptions.NotEnoughQuanityException;
import com.example.inventoryManagementService.customExceptions.PostgresException;
import com.example.inventoryManagementService.customExceptions.ProductNotFoundException;
import com.example.inventoryManagementService.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {

    Product getById(int productId) throws PostgresException;

    List<Product> getByName(String name);

    List<Product> searchByName(String query);

    Page<Product> getAll(int page,int size);

    Product postProduct(Product product);

    Iterable<Product> postProduct(List<Product> product);

    Iterable<Product> incrementQuantityViaKafka(String data) throws JsonProcessingException;

    boolean checkStocks(Product product) throws ProductNotFoundException, NotEnoughQuanityException;
    boolean checkStocks(List<Product> product) throws ProductNotFoundException, NotEnoughQuanityException;

    boolean incrementQuantity(Product product) throws ProductNotFoundException, NotEnoughQuanityException;
    boolean incrementQuantity(Iterable<Product> product) throws ProductNotFoundException, NotEnoughQuanityException;

    boolean reduceQuantity(Product product) throws ProductNotFoundException, NotEnoughQuanityException;
    boolean reduceQuantity(List<Product> product) throws ProductNotFoundException, NotEnoughQuanityException;

    Product putProduct(Product product) throws PostgresException, InvalidDataProvidedException;

    Product deleteEmployee(int employeeId) throws PostgresException;

}
