package com.agiles.UniChain.feature.club.service;

import com.agiles.UniChain.feature.club.entity.Club;
import com.agiles.UniChain.feature.club.payload.request.ClubRequestDto;
import com.agiles.UniChain.feature.student.payload.request.StudentRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ClubService extends IService<Club, ClubRequestDto, GenericSearchDto> {
    public void createUpdated(ClubRequestDto requestDto, MultipartFile image) throws IOException;
}
