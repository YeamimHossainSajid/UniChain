package com.agiles.UniChain.feature.Routs.payload.request;

import lombok.Data;
import java.time.LocalTime;

@Data
public class BusRouteRequestDTO {

    private String location;
    private LocalTime estimatedArrivalTime;
    private String estimatedDurationAtLocation;
    private Long busId;
}