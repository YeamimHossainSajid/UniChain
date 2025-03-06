package com.agiles.UniChain.feature.classschedules.payload.response;

import java.util.List;

public class CourseResponseDto {
    private Long id;
    private String name;
    private String code;
    private FacultyResponseDto faculty;
    private List<ClassScheduleResponseDto> classSchedules;
    private List<AssignmentResponseDto> assignments;
    private List<ExamScheduleResponseDto> examSchedules;
}
