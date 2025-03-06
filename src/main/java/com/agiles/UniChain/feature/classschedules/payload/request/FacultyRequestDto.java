package com.agiles.UniChain.feature.classschedules.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class FacultyRequestDto implements IDto {
    private String name;
    private String email;
    private String phone;
    private String department;
    private MultipartFile image;
    private String officeHours;
}
