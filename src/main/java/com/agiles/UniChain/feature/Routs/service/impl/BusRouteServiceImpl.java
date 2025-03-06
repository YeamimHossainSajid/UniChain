package com.agiles.UniChain.feature.Routs.service.impl;

import com.agiles.UniChain.feature.Routs.entity.BusRoute;
import com.agiles.UniChain.feature.Routs.payload.request.BusRouteRequestDTO;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;

public class BusRouteServiceImpl extends AbstractService<BusRoute, BusRouteRequestDTO, GenericSearchDto> {
    public BusRouteServiceImpl(AbstractRepository<BusRoute> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(BusRoute busRoute) {
        return null;
    }

    @Override
    protected BusRoute convertToEntity(BusRouteRequestDTO busRouteRequestDTO) throws IOException {
        return null;
    }

    @Override
    protected BusRoute updateEntity(BusRouteRequestDTO busRouteRequestDTO, BusRoute entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<BusRoute> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
