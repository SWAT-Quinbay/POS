package com.example.orderManagementService.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name = "orderedProduct")
public class OrderedProduct {

    @EmbeddedId
    private OrderedProductPK orderedProductPK;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id",insertable = false, updatable = false)
    private Order order;

    private String name;
    private String description;
    private float price;
    @Column(name = "image_url")
    private String imageUrl;
    private int quantity;

}

@Embeddable
@Data
@EqualsAndHashCode
class OrderedProductPK implements Serializable{

    @Column(name = "order_id",nullable = false)
    private int orderId;
    @Column(name = "pid",nullable = false)
    private int pid;

}
