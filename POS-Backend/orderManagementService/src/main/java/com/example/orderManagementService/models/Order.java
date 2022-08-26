package com.example.orderManagementService.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private List<OrderedProduct> products;
    @CreationTimestamp
    private Date createdDate;
    private String status;
}
