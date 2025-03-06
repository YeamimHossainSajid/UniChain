package com.agiles.UniChain.feature.Routs.service;

import com.agiles.UniChain.feature.Routs.entity.BusRoute;
import com.agiles.UniChain.feature.Routs.payload.request.BusRouteRequestDTO;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.IService;

public interface BusRouteService extends IService<BusRoute, BusRouteRequestDTO, GenericSearchDto> {
}
