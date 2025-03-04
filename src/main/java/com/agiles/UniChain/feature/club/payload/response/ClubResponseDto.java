package com.agiles.UniChain.feature.club.payload.response;

import com.agiles.UniChain.feature.club.payload.response.EventResponseDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ClubResponseDto extends BaseResponseDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String email;
    private String contactNo;
    private List<EventResponseDto> events;
}
