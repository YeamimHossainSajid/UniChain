package com.agiles.UniChain.feature.communicationhub.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;

@Data
public class UniversityUpdateRequest implements IDto {
    private String time;
    private String description;
}
