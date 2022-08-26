package com.example.inventoryManagementService;

import com.example.inventoryManagementService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByNameContainingIgnoreCase(String query);
}
