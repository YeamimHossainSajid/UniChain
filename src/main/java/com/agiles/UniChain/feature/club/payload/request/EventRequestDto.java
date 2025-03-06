package com.agiles.UniChain.feature.club.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EventRequestDto implements IDto {

    private String title;
    private String description;
    private LocalDate startTime;
    private LocalDate endTime;
    private String location;
    private MultipartFile imageUrl;
    private Long clubId;

}
