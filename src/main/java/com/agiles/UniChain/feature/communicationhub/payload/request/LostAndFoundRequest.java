package com.agiles.UniChain.feature.communicationhub.payload.request;

import com.agiles.UniChain.config.swagger.LocalTimeDeserializer;
import com.agiles.UniChain.generic.payload.request.IDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalTime;

@Data
public class LostAndFoundRequest implements IDto {
    String name;
    String contacts;
    MultipartFile picture;
    String description;
}
