package com.agiles.UniChain.feature.classschedules.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;

import java.time.LocalDate;

public class AssignmentRequestDto implements IDto {
    private String title;
    private LocalDate dueDate;
    private String status;
    private Long courseId;
}
