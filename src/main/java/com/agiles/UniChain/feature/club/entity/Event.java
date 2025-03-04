package com.agiles.UniChain.feature.club.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
public class Event extends BaseEntity {
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;


}