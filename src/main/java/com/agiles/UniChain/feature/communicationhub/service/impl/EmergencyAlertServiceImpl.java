package com.agiles.UniChain.feature.communicationhub.service.impl;

import com.agiles.UniChain.feature.communicationhub.entity.EmergencyAlert;
import com.agiles.UniChain.feature.communicationhub.payload.request.EmergencyAlertRequestDto;
import com.agiles.UniChain.feature.communicationhub.payload.response.EmergencyAlertResponseDto;
import com.agiles.UniChain.feature.communicationhub.service.EmergencyAlertService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmergencyAlertServiceImpl extends AbstractService<EmergencyAlert, EmergencyAlertRequestDto, GenericSearchDto> implements EmergencyAlertService {
    public EmergencyAlertServiceImpl(AbstractRepository<EmergencyAlert> repository) {
        super(repository);
    }

    @Override
    protected EmergencyAlertResponseDto convertToResponseDto(EmergencyAlert emergencyAlert) {
        EmergencyAlertResponseDto responseDto = new EmergencyAlertResponseDto();
        responseDto.setAlertDescription(emergencyAlert.getAlertDescription());
        responseDto.setAlertType(emergencyAlert.getAlertType());
        responseDto.setTime(emergencyAlert.getTime());
        return responseDto;
    }

    @Override
    protected EmergencyAlert convertToEntity(EmergencyAlertRequestDto emergencyAlertRequestDto) throws IOException {
        return updateEntity(emergencyAlertRequestDto,new EmergencyAlert());
    }

    @Override
    protected EmergencyAlert updateEntity(EmergencyAlertRequestDto emergencyAlertRequestDto, EmergencyAlert entity) throws IOException {
        entity.setAlertDescription(emergencyAlertRequestDto.getAlertDescription());
        entity.setAlertType(emergencyAlertRequestDto.getAlertType());
        entity.setTime(emergencyAlertRequestDto.getTime());
        return entity;
    }

    @Override
    protected Specification<EmergencyAlert> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
