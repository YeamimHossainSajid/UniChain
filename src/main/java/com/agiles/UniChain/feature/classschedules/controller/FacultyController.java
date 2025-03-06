package com.agiles.UniChain.feature.classschedules.controller;

import com.agiles.UniChain.feature.classschedules.entity.Faculty;
import com.agiles.UniChain.feature.classschedules.payload.request.FacultyRequestDto;
import com.agiles.UniChain.feature.classschedules.service.FacultyService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Faculty")
public class FacultyController extends AbstractController<Faculty, FacultyRequestDto, GenericSearchDto> {
    public FacultyController(FacultyService service) {
        super(service);
    }
}
