package com.agiles.UniChain.feature.classschedules.controller;

import com.agiles.UniChain.feature.classschedules.entity.Faculty;
import com.agiles.UniChain.feature.classschedules.payload.request.FacultyRequestDto;
import com.agiles.UniChain.feature.classschedules.service.FacultyService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public class FacultyController extends AbstractController<Faculty, FacultyRequestDto, GenericSearchDto> {
    public FacultyController(FacultyService service) {
        super(service);
    }
}
