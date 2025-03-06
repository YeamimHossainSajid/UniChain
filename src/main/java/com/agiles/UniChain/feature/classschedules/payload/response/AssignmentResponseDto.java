package com.agiles.UniChain.feature.classschedules.payload.response;

import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AssignmentResponseDto extends BaseResponseDto {
    private String title;
    private LocalDate dueDate;
    private String status;
    private String image;
}
