package com.example.orderManagementService.utils;


import lombok.Data;

@Data
public class InventoryProduct {
    private int id;
    private String name;
    private String description;
    private float price;
    private String imageurl;
    private int quantity;
}
