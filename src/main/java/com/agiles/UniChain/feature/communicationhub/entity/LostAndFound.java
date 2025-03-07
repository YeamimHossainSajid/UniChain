package com.agiles.UniChain.feature.communicationhub.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
public class LostAndFound extends BaseEntity {
    String name;
    String contacts;
    String picture;
    String description;
    LocalTime time;
}
