package com.agiles.UniChain.feature.Routs.payload.response;

import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.Data;

@Data
public class AnnouncementResponseDto extends BaseResponseDto {

    private Long id;
    private String message;

}
