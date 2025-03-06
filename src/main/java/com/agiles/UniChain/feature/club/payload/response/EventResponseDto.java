package com.agiles.UniChain.feature.club.payload.response;

import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EventResponseDto extends BaseResponseDto {

    private Long id;
    private String title;
    private String description;
    private LocalDate startTime;
    private LocalDate endTime;
    private String location;
    private String imageUrl;

}
