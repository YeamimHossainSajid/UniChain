package com.agiles.UniChain.feature.communicationhub.controller;

import com.agiles.UniChain.feature.communicationhub.entity.EmergencyAlert;
import com.agiles.UniChain.feature.communicationhub.payload.request.EmergencyAlertRequestDto;
import com.agiles.UniChain.feature.communicationhub.service.EmergencyAlertService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emergencyAlert")
public class EmergencyAlertController extends AbstractController<EmergencyAlert, EmergencyAlertRequestDto, GenericSearchDto> {
    public EmergencyAlertController(IService<EmergencyAlert, EmergencyAlertRequestDto, GenericSearchDto> service) {
        super(service);
    }
}
