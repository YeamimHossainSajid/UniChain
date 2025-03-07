package com.agiles.UniChain.feature.communicationhub.payload.response;

import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

@Data
public class UniversityUpdateResponse extends BaseResponseDto {
    private String time;
    private String description;
}
