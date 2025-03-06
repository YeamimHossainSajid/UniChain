package com.agiles.UniChain.feature.Routs.payload.response;

import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;
import java.util.List;

@Data
public class BusResponseDTO extends BaseResponseDto {

    private Long id;
    private String busNumber;
    private String startPoint;
    private String endPoint;
    private List<BusRouteResponseDTO> routes;
    private List<AnnouncementResponseDto>announcements;

}