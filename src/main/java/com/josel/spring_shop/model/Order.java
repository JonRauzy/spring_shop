package com.josel.spring_shop.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "items")
public class Order {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable (name = "order_item",
      JoinColumns = @JoinColumn (name = "item_id"),
      inverseJoinColums = @JoinColumns (name = "order_id")
    )
    private List<Item> items = new ArrayList<>();

}