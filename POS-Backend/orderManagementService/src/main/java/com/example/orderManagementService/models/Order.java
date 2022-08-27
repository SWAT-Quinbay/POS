package com.example.orderManagementService.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    @Column(name = "created_time")
    private Date createdTime;
    private String status;
    @Column(name = "net_total")
    private int netTotal;

    @OneToMany(mappedBy = "orderedProduct", cascade = CascadeType.ALL)
    List<OrderedProduct> products;
}
