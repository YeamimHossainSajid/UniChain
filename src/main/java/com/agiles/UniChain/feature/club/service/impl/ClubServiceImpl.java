package com.agiles.UniChain.feature.club.service.impl;

import com.agiles.UniChain.config.image.service.CloudneryImageService;
import com.agiles.UniChain.feature.club.entity.Club;
import com.agiles.UniChain.feature.club.entity.Event;
import com.agiles.UniChain.feature.club.payload.request.ClubRequestDto;
import com.agiles.UniChain.feature.club.payload.response.ClubResponseDto;
import com.agiles.UniChain.feature.club.payload.response.EventResponseDto;
import com.agiles.UniChain.feature.club.repository.ClubRepository;
import com.agiles.UniChain.feature.club.service.ClubService;
import com.agiles.UniChain.feature.student.payload.request.StudentRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl extends AbstractService<Club, ClubRequestDto, GenericSearchDto> implements ClubService {

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    private CloudneryImageService cloudneryImageService;

    public ClubServiceImpl(AbstractRepository<Club> repository) {
        super(repository);
    }

    @Override
    protected ClubResponseDto convertToResponseDto(Club club) {
        ClubResponseDto responseDto = new ClubResponseDto();
        responseDto.setId(club.getId());
        responseDto.setName(club.getName());
        responseDto.setDescription(club.getDescription());
        responseDto.setImageUrl(club.getImageUrl());
        responseDto.setEmail(club.getEmail());
        responseDto.setContactNo(club.getContactNo());


        List<EventResponseDto> eventDtos = club.getEvents().stream()
                .map(this::convertToEventResponseDto)
                .collect(Collectors.toList());
        responseDto.setEvents(eventDtos);

        return responseDto;
    }

    private EventResponseDto convertToEventResponseDto(Event event) {
        EventResponseDto eventDto = new EventResponseDto();
        eventDto.setId(event.getId());
        eventDto.setTitle(event.getTitle());
        eventDto.setDescription(event.getDescription());
        eventDto.setStartTime(event.getStartTime());
        eventDto.setEndTime(event.getEndTime());
        eventDto.setLocation(event.getLocation());
        eventDto.setImageUrl(event.getImageUrl());
        return eventDto;
    }

    @Override
    protected Club convertToEntity(ClubRequestDto clubRequestDto) throws IOException {
        return updateEntity(clubRequestDto, new Club());
    }

    @Override
    protected Club updateEntity(ClubRequestDto clubRequestDto, Club entity) throws IOException {

        MultipartFile file = clubRequestDto.getImageUrl();
        if (file != null && !file.isEmpty()) {
            Map<String, Object> uploadResult = cloudneryImageService.upload(file);
            entity.setImageUrl((String) uploadResult.get("secure_url"));
        }


        entity.setName(clubRequestDto.getName());
        entity.setDescription(clubRequestDto.getDescription());
        entity.setEmail(clubRequestDto.getEmail());
        entity.setContactNo(clubRequestDto.getContactNo());

        return entity;
    }

    @Override
    protected Specification<Club> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }

    @Override
    public void createUpdated(ClubRequestDto requestDto, MultipartFile image) throws IOException {

        Club entity=new Club();

        if (image != null && !image.isEmpty()) {
            Map<String, Object> uploadResult = cloudneryImageService.upload(image);
            entity.setImageUrl((String) uploadResult.get("secure_url"));
        }


        entity.setName(requestDto.getName());
        entity.setDescription(requestDto.getDescription());
        entity.setEmail(requestDto.getEmail());
        entity.setContactNo(requestDto.getContactNo());

        clubRepository.save(entity);
    }
}