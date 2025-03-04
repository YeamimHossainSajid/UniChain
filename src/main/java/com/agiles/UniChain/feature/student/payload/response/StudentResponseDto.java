package com.agiles.UniChain.feature.student.payload.response;

import com.agiles.UniChain.auth.dto.response.CustomUserResponseDTO;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

@Data
public class StudentResponseDto extends BaseResponseDto {

    private Long id;
    private String name;
    private String phoneNumber;
    private String department;
    private String major;
    private String batch;
    private String semester;
    private String cgpa;
    private String interests;
    private String futurePlans;
    private String profileImage;

    CustomUserResponseDTO user;

}
