package com.agiles.UniChain.feature.communicationhub.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class UniversityUpdate extends BaseEntity {

    private String time;
    private String description;


}
