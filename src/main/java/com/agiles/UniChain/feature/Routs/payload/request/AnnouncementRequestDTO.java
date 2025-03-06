package com.agiles.UniChain.feature.Routs.payload.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AnnouncementRequestDTO {
    private String message;
    private Long busId;
}