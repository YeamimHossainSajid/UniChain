package com.agiles.UniChain.feature.communicationhub.payload.response;

import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

@Data
public class EmergencyAlertResponseDto extends BaseResponseDto {

    private String alertType;
    private String alertDescription;
    private String time;

}


