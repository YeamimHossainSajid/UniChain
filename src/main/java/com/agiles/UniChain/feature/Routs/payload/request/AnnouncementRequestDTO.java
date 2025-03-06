package com.agiles.UniChain.feature.Routs.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AnnouncementRequestDTO implements IDto {
    private String message;
    private Long busId;
}