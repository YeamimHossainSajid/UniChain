package com.agiles.UniChain.feature.Routs.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Announcement extends BaseEntity {

    private String message;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;
}