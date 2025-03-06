package com.agiles.UniChain.feature.Routs.service.impl;

import com.agiles.UniChain.feature.Routs.entity.Bus;
import com.agiles.UniChain.feature.Routs.payload.request.BusRequestDTO;
import com.agiles.UniChain.feature.Routs.payload.response.AnnouncementResponseDto;
import com.agiles.UniChain.feature.Routs.payload.response.BusResponseDTO;
import com.agiles.UniChain.feature.Routs.payload.response.BusRouteResponseDTO;
import com.agiles.UniChain.feature.Routs.repository.BusRepository;
import com.agiles.UniChain.feature.Routs.service.BusService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl extends AbstractService<Bus, BusRequestDTO, GenericSearchDto> implements BusService {

    @Autowired
    private BusRepository busRepository;

    public BusServiceImpl(AbstractRepository<Bus> repository) {
        super(repository);
    }

    @Override
    protected BusResponseDTO convertToResponseDto(Bus bus) {
        BusResponseDTO responseDto = new BusResponseDTO();
        responseDto.setId(bus.getId());
        responseDto.setBusNumber(bus.getBusNumber());
        responseDto.setStartPoint(bus.getStartPoint());
        responseDto.setEndPoint(bus.getEndPoint());

        responseDto.setRoutes(bus.getRoutes().stream()
                .map(route -> {
                    BusRouteResponseDTO routeDto = new BusRouteResponseDTO();
                    routeDto.setId(route.getId());
                    routeDto.setLocation(route.getLocation());
                    routeDto.setEstimatedArrivalTime(route.getEstimatedArrivalTime());
                    routeDto.setEstimatedDurationAtLocation(route.getEstimatedDurationAtLocation());
                    return routeDto;
                }).collect(Collectors.toList()));

        responseDto.setAnnouncements(bus.getAnnouncements().stream()
                .map(announcement -> {
                    AnnouncementResponseDto announcementDto = new AnnouncementResponseDto();
                    announcementDto.setId(announcement.getId());
                    announcementDto.setMessage(announcement.getMessage());
                    return announcementDto;
                }).collect(Collectors.toList()));

        return responseDto;
    }

    @Override
    protected Bus convertToEntity(BusRequestDTO busRequestDTO) throws IOException {
        return updateEntity(busRequestDTO, new Bus());
    }

    @Override
    protected Bus updateEntity(BusRequestDTO busRequestDTO, Bus entity) throws IOException {
        entity.setBusNumber(busRequestDTO.getBusNumber());
        entity.setStartPoint(busRequestDTO.getStartPoint());
        entity.setEndPoint(busRequestDTO.getEndPoint());
        return entity;
    }

    @Override
    protected Specification<Bus> buildSpecification(GenericSearchDto searchDto) {
        return null; // Future implementation for filtering buses
    }

}
