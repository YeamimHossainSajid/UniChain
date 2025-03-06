package com.agiles.UniChain.feature.Routs.payload.response;

import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;
import java.time.LocalTime;

@Data
public class BusRouteResponseDTO extends BaseResponseDto {

    private Long id;
    private String location;
    private LocalTime estimatedArrivalTime;
    private String estimatedDurationAtLocation;

}