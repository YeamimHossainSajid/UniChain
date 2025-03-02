package com.agiles.UniChain.feature.canteen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String shortDescription;
    private String ingredients;
    private String preparationMethod;
    private String quantity;
    private Boolean available;

    @ManyToOne
    private Restaurant restaurant;

}

