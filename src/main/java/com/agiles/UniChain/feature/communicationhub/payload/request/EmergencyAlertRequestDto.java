package com.agiles.UniChain.feature.communicationhub.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;


@Data
public class EmergencyAlertRequestDto implements IDto {

    private String alertType;
    private String alertDescription;
    private String time;

}
