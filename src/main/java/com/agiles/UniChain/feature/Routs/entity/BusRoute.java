package com.agiles.UniChain.feature.Routs.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
public class BusRoute extends BaseEntity {

    private String location;
    private LocalTime estimatedArrivalTime;
    private String estimatedDurationAtLocation;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;
}
