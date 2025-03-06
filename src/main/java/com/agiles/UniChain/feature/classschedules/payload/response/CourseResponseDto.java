package com.agiles.UniChain.feature.classschedules.payload.response;

import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class CourseResponseDto extends BaseResponseDto {
    private Long id;
    private String name;
    private String code;
    private FacultyResponseDto faculty;
    private List<ClassScheduleResponseDto> classSchedules;
    private List<AssignmentResponseDto> assignments;
    private List<ExamScheduleResponseDto> examSchedules;
}
