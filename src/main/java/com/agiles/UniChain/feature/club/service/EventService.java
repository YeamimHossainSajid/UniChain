package com.agiles.UniChain.feature.club.service;

import com.agiles.UniChain.feature.club.entity.Event;
import com.agiles.UniChain.feature.club.payload.request.EventRequestDto;
import com.agiles.UniChain.feature.student.payload.request.StudentRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EventService extends IService<Event, EventRequestDto, GenericSearchDto> {
    public void createUpdated(EventRequestDto requestDto, MultipartFile image) throws IOException;
}
