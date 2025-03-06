package com.agiles.UniChain.feature.classschedules.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExamScheduleRequestDto implements IDto {
    private LocalDate date;
    private LocalTime time;
    private String location;
    private Long courseId;
}
