package com.agiles.UniChain.feature.student.payload.request;


import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class StudentRequestDto implements IDto {

    private String name;
    private String phoneNumber;
    private String department;
    private String major;
    private String batch;
    private String semester;
    private String cgpa;
    private String interests;
    private String futurePlans;

    Long userId;

}
