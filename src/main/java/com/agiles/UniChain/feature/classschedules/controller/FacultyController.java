package com.agiles.UniChain.feature.classschedules.controller;

import com.agiles.UniChain.feature.classschedules.entity.Faculty;
import com.agiles.UniChain.feature.classschedules.payload.request.FacultyRequestDto;
import com.agiles.UniChain.feature.classschedules.service.FacultyService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("{userId}/{name}/{id}/{email}/{phone}/{text}")
    public ResponseEntity<String> sendMail(@PathVariable Long userId,@PathVariable String name,@PathVariable String id,@PathVariable String email, @PathVariable String phone,@PathVariable String text){
        facultyService.sendMail(userId,name,id,email,phone,text);
        return ResponseEntity.ok("Mail Sent");
    }
}
