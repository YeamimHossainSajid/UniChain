package com.agiles.UniChain.feature.classschedules.payload.response;

import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ExamScheduleResponseDto extends BaseResponseDto {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private CourseResponseDto course;
}
