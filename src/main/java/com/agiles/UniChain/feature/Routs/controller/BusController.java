package com.agiles.UniChain.feature.Routs.controller;

import com.agiles.UniChain.feature.Routs.entity.Bus;
import com.agiles.UniChain.feature.Routs.payload.request.BusRequestDTO;
import com.agiles.UniChain.feature.Routs.service.BusService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.GenericArrayType;

@RestController
@RequestMapping("bus")
public class BusController extends AbstractController <Bus, BusRequestDTO, GenericSearchDto> {
    public BusController(IService<Bus, BusRequestDTO, GenericSearchDto> service) {
        super(service);
    }
}
