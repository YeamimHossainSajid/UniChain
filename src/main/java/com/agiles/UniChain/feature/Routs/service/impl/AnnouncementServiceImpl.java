package com.agiles.UniChain.feature.Routs.service.impl;

import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.auth.repository.UserRepo;
import com.agiles.UniChain.config.mail.EmailService;
import com.agiles.UniChain.feature.Routs.entity.Announcement;
import com.agiles.UniChain.feature.Routs.entity.Bus;
import com.agiles.UniChain.feature.Routs.payload.request.AnnouncementRequestDTO;
import com.agiles.UniChain.feature.Routs.payload.response.AnnouncementResponseDto;
import com.agiles.UniChain.feature.Routs.repository.BusRepository;
import com.agiles.UniChain.feature.Routs.service.AnnouncementService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementServiceImpl extends AbstractService<Announcement, AnnouncementRequestDTO, GenericSearchDto> implements AnnouncementService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmailService emailService;

    public AnnouncementServiceImpl(AbstractRepository<Announcement> repository) {
        super(repository);
    }

    @Override
    protected AnnouncementResponseDto convertToResponseDto(Announcement announcement) {
        AnnouncementResponseDto responseDto = new AnnouncementResponseDto();
        responseDto.setId(announcement.getId());
        responseDto.setMessage(announcement.getMessage());
        return responseDto;
    }

    @Override
    protected Announcement convertToEntity(AnnouncementRequestDTO announcementRequestDTO) throws IOException {
        List<User> users = userRepo.findAll();
        String announcementMessage = announcementRequestDTO.getMessage();
        for (User user : users) {
          emailService.sendAnnouncementEmail(user.getEmail(), announcementMessage);
        }

        return updateEntity(announcementRequestDTO, new Announcement());
    }

    @Override
    protected Announcement updateEntity(AnnouncementRequestDTO announcementRequestDTO, Announcement entity) throws IOException {
        entity.setMessage(announcementRequestDTO.getMessage());

        if (announcementRequestDTO.getBusId() != null) {
            Optional<Bus> bus = busRepository.findById(announcementRequestDTO.getBusId());
            bus.ifPresent(entity::setBus);
        }

        return entity;
    }

    @Override
    protected Specification<Announcement> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}

