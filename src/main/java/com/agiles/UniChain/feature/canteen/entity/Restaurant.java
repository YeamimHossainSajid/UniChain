package com.agiles.UniChain.feature.canteen.entity;

import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant extends BaseEntity {

    private String name;
    private String description;
    private String location;
    private String contactNumber;
    private String contactNumber2;
    private String email;
    private String isOpen;
    private String image;

    @OneToOne( mappedBy = "restaurant" , cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodItem> foodItems = new ArrayList<>();

    public void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
        foodItem.setRestaurant(this);
    }

    public void removeFoodItem(FoodItem foodItem) {
        foodItems.remove(foodItem);
        foodItem.setRestaurant(null);
    }
}

