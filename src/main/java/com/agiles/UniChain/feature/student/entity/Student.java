package com.agiles.UniChain.feature.student.entity;

import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student extends BaseEntity {
    private String name;
    private String phoneNumber;
    private String department;
    private String major;
    private String batch;
    private String semester;
    private String cgpa;
    private String interests;
    private String futurePlans;
    private String profileImage;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    public void setUser(User user) {
        this.user = user;
        if (user != null && user.getStudent() != this) {
            user.setStudent(this);
        }
    }
}