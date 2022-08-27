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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        return inventoryRepository.findAllByName(name);
    }

    @Override
    public List<Product> searchByName(String query) {

        return inventoryRepository.findAllByNameContainingIgnoreCase(query,Sort.by(Sort.Direction.ASC,"name"));
    }

    @Override
    public Page<Product> getAll(int page, int size) {
        PageRequest pr = PageRequest.of(page,size,Sort.by("quantity").descending());
        return inventoryRepository.findAll(pr);
    }

    @Override
    public Product postProduct(Product product) {
        return inventoryRepository.save(product);
    }

    @Override
    public Iterable<Product> postProduct(List<Product> employees) {
        return inventoryRepository.saveAll(employees);
    }

    @Override
    public Iterable<Product> incrementQuantityViaKafka(String message)
            throws JsonProcessingException {

        TypeReference<List<Product>> ref = new TypeReference<List<Product>>() {
        };

        Iterable<Product> orderedProducts = postProduct(objectMapper.readValue(message, ref));
        incrementQuantity(orderedProducts);
        return orderedProducts;
    }

    @Override
    public boolean checkStocks(Product orderedProduct) throws ProductNotFoundException, NotEnoughQuanityException {
        Optional<Product> result = inventoryRepository.findById(orderedProduct.getId());

        if (!result.isPresent()) {
            throw new ProductNotFoundException("Invalid Product Id with " + orderedProduct.getId());
        }

        Product originalProduct = result.get();

        if (originalProduct.getQuantity() < orderedProduct.getQuantity()) {
            throw new NotEnoughQuanityException("The Quantity");
        }

        return true;
    }

    @Override
    public boolean checkStocks(List<Product> products) throws ProductNotFoundException, NotEnoughQuanityException {
        for(Product product :products){
            checkStocks(product);
        }
        return true;
    }

    @Override
    public boolean incrementQuantity(Product product){
        updateQuantity(product,true);
        return true;
    }

    @Override
    public boolean incrementQuantity(Iterable<Product> products){
        for(Product product:products){
            updateQuantity(product, true);
        }
        return true;
    }

    @Override
    public boolean reduceQuantity(Product product) throws ProductNotFoundException, NotEnoughQuanityException {
        checkStocks(product);
        updateQuantity(product,false);
        return true;
    }

    @Override
    public boolean reduceQuantity(List<Product> products) throws ProductNotFoundException, NotEnoughQuanityException {
        checkStocks(products);

        for(Product product:products){
            updateQuantity(product, false);
        }
        return true;
    }

    private void updateQuantity(Product orderedProduct, boolean isIncrement) {

        Optional<Product> result = inventoryRepository.findById(orderedProduct.getId());

        Product originalProduct = result.get();

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
