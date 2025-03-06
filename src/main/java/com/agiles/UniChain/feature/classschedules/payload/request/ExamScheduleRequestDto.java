package com.agiles.UniChain.feature.classschedules.payload.request;

import com.agiles.UniChain.config.swagger.LocalTimeDeserializer;
import com.agiles.UniChain.generic.payload.request.IDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class ExamScheduleRequestDto implements IDto {
    private LocalDate date;
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime time;
    private String location;
    private Long courseId;
}
