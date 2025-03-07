package com.agiles.UniChain.feature.communicationhub.controller;

import com.agiles.UniChain.feature.communicationhub.entity.UniversityUpdate;
import com.agiles.UniChain.feature.communicationhub.payload.request.UniversityUpdateRequest;
import com.agiles.UniChain.feature.communicationhub.service.UniversityUpdateService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("universityUpdate")
public class UniversityUpdateController extends AbstractController<UniversityUpdate, UniversityUpdateRequest, GenericSearchDto> {
    public UniversityUpdateController(IService<UniversityUpdate, UniversityUpdateRequest, GenericSearchDto> service) {
        super(service);
    }
}
