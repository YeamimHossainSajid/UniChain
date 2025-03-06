package com.agiles.UniChain.feature.classschedules.payload.response;

import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ClassScheduleResponseDto extends BaseResponseDto {
    private String day;
    private LocalTime time;
    private String location;
    private LocalTime reminderTime;
}
