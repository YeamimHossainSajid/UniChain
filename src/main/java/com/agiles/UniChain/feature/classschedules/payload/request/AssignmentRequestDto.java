package com.agiles.UniChain.feature.classschedules.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class AssignmentRequestDto implements IDto {
    private String title;
    private LocalDate dueDate;
    private String status;
    private MultipartFile image;
    private Long courseId;
}
