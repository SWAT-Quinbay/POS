package com.example.orderManagementService.utils;

import com.example.orderManagementService.customException.InvalidQuantityException;
import com.example.orderManagementService.models.Order;
import com.example.orderManagementService.models.OrderItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderJsonParser {
    public static Order extractOrder(JsonOrder jsonOrder){
        Order order = new Order();
        order.setId(jsonOrder.getId());
        order.setTax(jsonOrder.getTax());
        order.setCreatedTime(new Date());
        order.setSubTotal(jsonOrder.getSubTotal());
        order.setStatus(jsonOrder.getStatus());
        order.setPaymentMethod(jsonOrder.getPaymentMethod());

        return order;
    }

    public static List<OrderItem> extractItems(JsonOrder jsonOrder, Order order) throws InvalidQuantityException {
        List<OrderItem> items = new ArrayList<>();

        for (JsonOrderItem jsonOrderItem : jsonOrder.getOrderJsonOrderItems()){
            OrderItem orderItem  = new OrderItem();
            orderItem.setProduct_id(jsonOrderItem.getId());//product id
            orderItem.setItemId(jsonOrderItem.getItemId());
            orderItem.setName(jsonOrderItem.getName());
            orderItem.setDescription(jsonOrderItem.getDescription());
            orderItem.setPrice(jsonOrderItem.getPrice());
            orderItem.setImageUrl(jsonOrderItem.getImageUrl());


            if(jsonOrderItem.getQuantity() <= 0){
                throw new InvalidQuantityException("Quantity Should be a Positive number");
            }

            orderItem.setQuantity(jsonOrderItem.getQuantity());
            orderItem.setOrder(order);

            items.add(orderItem);
        }
        return items;
    }

    public static List<InventoryProduct> extractInventoryProduct(JsonOrder jsonOrder) throws InvalidQuantityException {
        List<InventoryProduct> inventoryProducts = new ArrayList<>();

        for(JsonOrderItem jsonOrderItem : jsonOrder.getOrderJsonOrderItems()){
            InventoryProduct inventoryProduct = new InventoryProduct();

            inventoryProduct.setId(jsonOrderItem.getId());
            inventoryProduct.setName(jsonOrderItem.getName());
            inventoryProduct.setDescription(jsonOrderItem.getDescription());
            inventoryProduct.setImageurl(jsonOrderItem.getImageUrl());
            inventoryProduct.setPrice(jsonOrderItem.getPrice());

            if(jsonOrderItem.getQuantity() <= 0){
                throw new InvalidQuantityException("Quantity Should be a Positive number");
            }

            inventoryProduct.setQuantity(jsonOrderItem.getQuantity());

            inventoryProducts.add(inventoryProduct);
        }
        return inventoryProducts;
    }
    public static List<InventoryProduct> extractInventoryProduct(List<OrderItem> items) {
        List<InventoryProduct> inventoryProducts = new ArrayList<>();

        for(OrderItem item : items){
            InventoryProduct inventoryProduct = new InventoryProduct();

            inventoryProduct.setId(item.getProduct_id());
            inventoryProduct.setName(item.getName());
            inventoryProduct.setDescription(item.getDescription());
            inventoryProduct.setImageurl(item.getImageUrl());
            inventoryProduct.setPrice(item.getPrice());
            inventoryProduct.setQuantity(item.getQuantity());

            inventoryProducts.add(inventoryProduct);
        }
        return inventoryProducts;
    }



//    private float tax;
//    private float subTotal;
//    private String status;
//    private String paymentMethod;

}
