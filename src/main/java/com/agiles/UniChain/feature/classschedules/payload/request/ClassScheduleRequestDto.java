package com.agiles.UniChain.feature.classschedules.payload.request;

import com.agiles.UniChain.config.swagger.LocalTimeDeserializer;
import com.agiles.UniChain.generic.payload.request.IDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ClassScheduleRequestDto implements IDto {
    private String day;
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime time;
    private String location;
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime reminderTime;
    private Long courseId;
}
