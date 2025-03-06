package com.agiles.UniChain.feature.classschedules.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "faculty")
public class Faculty extends BaseEntity {

    private String name;
    private String email;
    private String phone;
    private String department;
    private String officeHours;
    private String image;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;
}

