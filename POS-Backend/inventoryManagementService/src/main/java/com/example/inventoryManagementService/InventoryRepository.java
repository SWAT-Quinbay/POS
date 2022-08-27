package com.example.inventoryManagementService;

import com.example.inventoryManagementService.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface InventoryRepository extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByNameContainingIgnoreCase(String query);
}
