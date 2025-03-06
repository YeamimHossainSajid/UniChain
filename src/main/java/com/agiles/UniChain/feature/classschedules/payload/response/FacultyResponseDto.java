package com.agiles.UniChain.feature.classschedules.payload.response;

import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

import java.util.List;
@Data
public class FacultyResponseDto extends BaseResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String officeHours;
    private String image;
    private List<CourseResponseDto> courses;
}
