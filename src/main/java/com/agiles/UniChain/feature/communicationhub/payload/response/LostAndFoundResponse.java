package com.agiles.UniChain.feature.communicationhub.payload.response;

import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

import java.time.LocalTime;

@Data
public class LostAndFoundResponse extends BaseResponseDto {
    Long id;
    String name;
    String contacts;
    String picture;
    String description;
}
