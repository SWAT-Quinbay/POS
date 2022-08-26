package com.example.inventoryManagementService;

import com.example.inventoryManagementService.customExceptions.InvalidDataProvidedException;
import com.example.inventoryManagementService.customExceptions.NotEnoughQuanityException;
import com.example.inventoryManagementService.customExceptions.PostgresException;
import com.example.inventoryManagementService.customExceptions.ProductNotFoundException;
import com.example.inventoryManagementService.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InventoryServiceImp implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Logger logger;

    @Override
    public Product getById(int productId) throws PostgresException {

        Optional<Product> employee = inventoryRepository.findById(productId);

        if (!employee.isPresent()) {
            throw new PostgresException("Invalid Employee Id");
        }

        return employee.get();

    }

    @Override
    public List<Product> getByName(String name) {
        return inventoryRepository.findByName(name);
    }

    @Override
    public List<Product> searchByName(String query) {
        return inventoryRepository.findByNameContainingIgnoreCase(query);
    }

    @Override
    public List<Product> getAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Product postProduct(Product product) {
        return inventoryRepository.save(product);
    }

    @Override
    public List<Product> postProduct(List<Product> employees) {
        return inventoryRepository.saveAll(employees);
    }

    @Override
    public List<Product> incrementQuantityViaKafka(String message)
            throws JsonProcessingException, ProductNotFoundException, NotEnoughQuanityException {

        TypeReference<List<Product>> ref = new TypeReference<List<Product>>() {
        };

        List<Product> orderedProducts = postProduct(objectMapper.readValue(message, ref));
        incrementQuantity(orderedProducts);
        return orderedProducts;
    }

    @Override
    public boolean incrementQuantity(Product product) throws ProductNotFoundException, NotEnoughQuanityException {
        updateQuantity(product,true);
        return true;
    }

    @Override
    public boolean incrementQuantity(List<Product> products) throws ProductNotFoundException, NotEnoughQuanityException {
        for(Product product:products){
            updateQuantity(product, true);
        }
        return true;
    }

    @Override
    public boolean reduceQuantity(Product product) throws ProductNotFoundException, NotEnoughQuanityException {
        updateQuantity(product,false);
        return true;
    }

    @Override
    public boolean reduceQuantity(List<Product> products) throws ProductNotFoundException, NotEnoughQuanityException {
        for(Product product:products){
            updateQuantity(product, false);
        }
        return true;
    }

    private void updateQuantity(Product orderedProduct, boolean isIncrement)
            throws ProductNotFoundException, NotEnoughQuanityException {

        Optional<Product> result = inventoryRepository.findById(orderedProduct.getId());

        if (!result.isPresent()) {
            throw new ProductNotFoundException("Invalid Product Id with " + orderedProduct.getId());
        }

        Product originalProduct = result.get();

        if (!isIncrement && (originalProduct.getQuantity() < orderedProduct.getQuantity())) {
            throw new NotEnoughQuanityException("The Quantity");
        }

        int updatedQuantity;
        if(isIncrement){
            updatedQuantity = originalProduct.getQuantity() + orderedProduct.getQuantity();
        }else {
            updatedQuantity = originalProduct.getQuantity() - orderedProduct.getQuantity();
        }

        originalProduct.setQuantity(updatedQuantity);

        inventoryRepository.save(originalProduct);
    }



    @Override
    public Product putProduct(Product product) throws PostgresException, InvalidDataProvidedException {


        Product modifiedProduct = getById(product.getId());

        modifiedProduct.setId(product.getId());
        modifiedProduct.setName(product.getName());
        modifiedProduct.setPrice(product.getPrice());
        modifiedProduct.setImageurl(product.getImageurl());

        if(product.getQuantity() < 0){
            throw new InvalidDataProvidedException("Quantity Shoud be Postive number");
        }
        modifiedProduct.setQuantity(product.getQuantity());


        return inventoryRepository.save(modifiedProduct);
    }

    @Override
    public Product deleteEmployee(int productId) throws PostgresException {
        Product result = getById(productId);
        inventoryRepository.deleteById(productId);

        return result;
    }
}
