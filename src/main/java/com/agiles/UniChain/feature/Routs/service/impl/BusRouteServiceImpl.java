package com.agiles.UniChain.feature.Routs.service.impl;

import com.agiles.UniChain.feature.Routs.entity.Bus;
import com.agiles.UniChain.feature.Routs.entity.BusRoute;
import com.agiles.UniChain.feature.Routs.payload.request.BusRouteRequestDTO;
import com.agiles.UniChain.feature.Routs.payload.response.BusRouteResponseDTO;
import com.agiles.UniChain.feature.Routs.repository.BusRepository;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class BusRouteServiceImpl extends AbstractService<BusRoute, BusRouteRequestDTO, GenericSearchDto> {

    @Autowired
    private BusRepository busRepository;

    public BusRouteServiceImpl(AbstractRepository<BusRoute> repository) {
        super(repository);
    }

    @Override
    protected BusRouteResponseDTO convertToResponseDto(BusRoute busRoute) {
        BusRouteResponseDTO responseDto = new BusRouteResponseDTO();
        responseDto.setId(busRoute.getId());
        responseDto.setLocation(busRoute.getLocation());
        responseDto.setEstimatedArrivalTime(busRoute.getEstimatedArrivalTime());
        responseDto.setEstimatedDurationAtLocation(busRoute.getEstimatedDurationAtLocation());
        return responseDto;
    }

    @Override
    protected BusRoute convertToEntity(BusRouteRequestDTO busRouteRequestDTO) throws IOException {
        return updateEntity(busRouteRequestDTO, new BusRoute());
    }

    @Override
    protected BusRoute updateEntity(BusRouteRequestDTO busRouteRequestDTO, BusRoute entity) throws IOException {
        entity.setLocation(busRouteRequestDTO.getLocation());
        entity.setEstimatedArrivalTime(busRouteRequestDTO.getEstimatedArrivalTime());
        entity.setEstimatedDurationAtLocation(busRouteRequestDTO.getEstimatedDurationAtLocation());

        if (busRouteRequestDTO.getBusId() != null) {
            Optional<Bus> bus = busRepository.findById(busRouteRequestDTO.getBusId());
            bus.ifPresent(entity::setBus);
        }

        return entity;
    }

    @Override
    protected Specification<BusRoute> buildSpecification(GenericSearchDto searchDto) {
        return null; // Future implementation for filtering bus routes
    }
}
