package com.agiles.UniChain.feature.classschedules.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ClassScheduleRequestDto implements IDto {
    private String day;
    private LocalTime time;
    private String location;
    private LocalTime reminderTime;
    private Long courseId;
}
