package com.agiles.UniChain.feature.classschedules.payload.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExamScheduleResponseDto {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private CourseResponseDto course;
}
