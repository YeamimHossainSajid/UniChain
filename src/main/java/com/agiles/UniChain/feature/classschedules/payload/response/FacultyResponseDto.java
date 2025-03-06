package com.agiles.UniChain.feature.classschedules.payload.response;

import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;

import java.util.List;

public class FacultyResponseDto extends BaseResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String officeHours;
    private List<CourseResponseDto> courses;
}
