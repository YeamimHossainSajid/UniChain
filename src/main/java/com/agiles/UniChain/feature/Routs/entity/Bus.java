package com.agiles.UniChain.feature.Routs.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Bus extends BaseEntity {

    private String busNumber;
    private String startPoint;
    private String endPoint;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<BusRoute> routes;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Announcement> announcements;
}
