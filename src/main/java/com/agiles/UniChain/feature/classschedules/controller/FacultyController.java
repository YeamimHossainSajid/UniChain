package com.agiles.UniChain.feature.classschedules.controller;

import com.agiles.UniChain.feature.classschedules.entity.Faculty;
import com.agiles.UniChain.feature.classschedules.payload.request.AssignmentRequestDto;
import com.agiles.UniChain.feature.classschedules.payload.request.FacultyRequestDto;
import com.agiles.UniChain.feature.classschedules.service.FacultyService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("Faculty")
public class FacultyController extends AbstractController<Faculty, FacultyRequestDto, GenericSearchDto> {
   FacultyService facultyService;

    public FacultyController(FacultyService service) {
        super(service);
        this.facultyService = service;
    }

    @PostMapping(value = "create/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> create(@ModelAttribute FacultyRequestDto dto) throws IOException {
        MultipartFile imageFile = dto.getImage();
        facultyService.createV2(dto,imageFile);
        return ResponseEntity.ok("Assignment Created Successfully");
    }
}
