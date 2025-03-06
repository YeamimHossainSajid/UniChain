package com.agiles.UniChain.feature.classschedules.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;

@Data
public class CourseRequestDto implements IDto {
    private String name;
    private String code;
    private Long facultyId;
}
