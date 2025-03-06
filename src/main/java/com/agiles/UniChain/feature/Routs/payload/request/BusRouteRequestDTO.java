package com.agiles.UniChain.feature.Routs.payload.request;

import com.agiles.UniChain.config.swagger.LocalTimeDeserializer;
import com.agiles.UniChain.generic.payload.request.IDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import java.time.LocalTime;

@Data
public class BusRouteRequestDTO implements IDto {

    private String location;
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime estimatedArrivalTime;
    private String estimatedDurationAtLocation;
    private Long busId;
}