package com.agiles.UniChain.feature.club.controller;


import com.agiles.UniChain.feature.club.entity.Club;
import com.agiles.UniChain.feature.club.payload.request.ClubRequestDto;
import com.agiles.UniChain.feature.club.service.ClubService;
import com.agiles.UniChain.feature.student.payload.request.StudentRequestDto;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("club")
public class ClubController extends AbstractController <Club, ClubRequestDto, GenericSearchDto> {
    ClubService service;
    public ClubController(ClubService service) {
        super(service);
        this.service = service;
    }

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Override
    public ResponseEntity<String> create(@ModelAttribute ClubRequestDto dto) throws IOException {
        MultipartFile picture =dto.getImageUrl();
        service.createUpdated(dto,picture);
        return ResponseEntity.ok("Student created");
    }
}
