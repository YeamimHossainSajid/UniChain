package com.agiles.UniChain.feature.canteen.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
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
public class FoodItem extends BaseEntity {

    private String name;
    private double price;
    private String shortDescription;
    private String ingredients;
    private String preparationMethod;
    private String quantity;
    private Boolean available;
    private String image;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}

