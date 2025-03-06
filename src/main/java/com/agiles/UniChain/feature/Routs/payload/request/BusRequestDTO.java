package com.agiles.UniChain.feature.Routs.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;
import java.util.List;

@Data
public class BusRequestDTO implements IDto {

    private String busNumber;
    private String startPoint;
    private String endPoint;

}