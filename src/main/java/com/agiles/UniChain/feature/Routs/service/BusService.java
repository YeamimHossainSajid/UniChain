package com.agiles.UniChain.feature.Routs.service;

import com.agiles.UniChain.feature.Routs.entity.Bus;
import com.agiles.UniChain.feature.Routs.payload.request.BusRequestDTO;
import com.agiles.UniChain.feature.Routs.payload.request.BusRouteRequestDTO;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface BusService extends IService<Bus, BusRequestDTO, GenericSearchDto> {
}
