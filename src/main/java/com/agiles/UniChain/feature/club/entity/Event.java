package com.agiles.UniChain.feature.club.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Event extends BaseEntity {
    private String title;
    private String description;
    private LocalDate startTime;
    private LocalDate endTime;
    private String location;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;


}