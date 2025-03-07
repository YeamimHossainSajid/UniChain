package com.agiles.UniChain.feature.communicationhub.service.impl;

import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.auth.repository.UserRepo;
import com.agiles.UniChain.config.mail.EmailService;
import com.agiles.UniChain.feature.communicationhub.entity.EmergencyAlert;
import com.agiles.UniChain.feature.communicationhub.payload.request.EmergencyAlertRequestDto;
import com.agiles.UniChain.feature.communicationhub.payload.response.EmergencyAlertResponseDto;
import com.agiles.UniChain.feature.communicationhub.service.EmergencyAlertService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmergencyAlertServiceImpl extends AbstractService<EmergencyAlert, EmergencyAlertRequestDto, GenericSearchDto> implements EmergencyAlertService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    EmailService emailService;
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
        List<User>users = userRepo.findAll();

        for (User user : users) {
            String userEmail = user.getEmail();

            if (isValidEmail(userEmail)) {
                emailService.sendEmergencyAlertEmail(userEmail, emergencyAlertRequestDto.getAlertType(), emergencyAlertRequestDto.getTime());
            } else {
                System.out.println("Skipping invalid email: " + userEmail);
            }
        }
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

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}
