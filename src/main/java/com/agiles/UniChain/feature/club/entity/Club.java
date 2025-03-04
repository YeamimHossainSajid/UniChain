package com.agiles.UniChain.feature.club.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Club extends BaseEntity {

    private String name;
    private String description;
    private String imageUrl;
    private String email;
    private String contactNo;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events;
}
