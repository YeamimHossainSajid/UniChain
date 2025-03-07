package com.agiles.UniChain.feature.communicationhub.controller;

import com.agiles.UniChain.feature.communicationhub.entity.LostAndFound;
import com.agiles.UniChain.feature.communicationhub.payload.request.LostAndFoundRequest;
import com.agiles.UniChain.feature.communicationhub.service.LostAndFoundService;
import com.agiles.UniChain.feature.student.payload.request.StudentRequestDto;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("LostAndFound")
public class LostAndFoundController extends AbstractController<LostAndFound, LostAndFoundRequest, GenericSearchDto> {

    @Autowired
    LostAndFoundService lostAndFoundService;

    public LostAndFoundController(IService<LostAndFound, LostAndFoundRequest, GenericSearchDto> service) {
        super(service);
    }

    @PostMapping(value = "/add/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> create(@ModelAttribute LostAndFoundRequest dto) throws IOException {
       MultipartFile image=dto.getPicture();
        lostAndFoundService.createV2(dto,image);
        return ResponseEntity.ok("Student created");
    }

}
