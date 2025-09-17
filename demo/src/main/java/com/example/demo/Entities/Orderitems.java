package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orderitems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderitemId;

    private Integer quantity;

//    @ManyToOne
//    @JoinColumn(name = "order_id",nullable = false)
//    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
}
