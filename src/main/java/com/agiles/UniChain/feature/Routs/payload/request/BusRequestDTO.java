package com.agiles.UniChain.feature.Routs.payload.request;

import lombok.Data;
import java.util.List;

@Data
public class BusRequestDTO {

    private String busNumber;
    private String startPoint;
    private String endPoint;

}