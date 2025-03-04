package com.agiles.UniChain.feature.club.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ClubRequestDto implements IDto {

    private String name;
    private String description;
    private MultipartFile imageUrl;
    private String email;
    private String contactNo;

}
