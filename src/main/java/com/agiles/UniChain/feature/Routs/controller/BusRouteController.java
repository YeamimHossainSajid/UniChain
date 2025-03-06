package com.agiles.UniChain.feature.Routs.controller;

import com.agiles.UniChain.feature.Routs.entity.BusRoute;
import com.agiles.UniChain.feature.Routs.payload.request.BusRouteRequestDTO;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bus/route")
public class BusRouteController extends AbstractController <BusRoute, BusRouteRequestDTO, GenericSearchDto> {
    public BusRouteController(IService<BusRoute, BusRouteRequestDTO, GenericSearchDto> service) {
        super(service);
    }
}
