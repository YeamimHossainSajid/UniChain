package com.agiles.UniChain.feature.Routs.payload.response;

import lombok.Data;
import java.util.List;

@Data
public class BusResponseDTO {

    private Long id;
    private String busNumber;
    private String startPoint;
    private String endPoint;
    private List<BusRouteResponseDTO> routes;

}