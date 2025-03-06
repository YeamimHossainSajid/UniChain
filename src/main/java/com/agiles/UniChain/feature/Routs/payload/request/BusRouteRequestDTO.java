package com.agiles.UniChain.feature.Routs.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;
import java.time.LocalTime;

@Data
public class BusRouteRequestDTO implements IDto {

    private String location;
    private LocalTime estimatedArrivalTime;
    private String estimatedDurationAtLocation;
    private Long busId;
}