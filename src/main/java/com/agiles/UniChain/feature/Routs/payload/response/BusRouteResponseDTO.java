package com.agiles.UniChain.feature.Routs.payload.response;

import lombok.Data;
import java.time.LocalTime;

@Data
public class BusRouteResponseDTO {

    private Long id;
    private String location;
    private LocalTime estimatedArrivalTime;
    private String estimatedDurationAtLocation;

}