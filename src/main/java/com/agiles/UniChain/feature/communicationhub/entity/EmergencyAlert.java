package com.agiles.UniChain.feature.communicationhub.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class EmergencyAlert extends BaseEntity {

    private String alertType;
    private String alertDescription;
    private String time;



}
