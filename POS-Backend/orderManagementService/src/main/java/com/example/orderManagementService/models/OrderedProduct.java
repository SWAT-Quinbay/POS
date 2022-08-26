package com.example.orderManagementService.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orderedproduct")
public class OrderedProduct {
    @Id
    private int order_id;
    private int pid;
    private String name;
    private float price;
    private String imageurl;
    private int quatity;
}
