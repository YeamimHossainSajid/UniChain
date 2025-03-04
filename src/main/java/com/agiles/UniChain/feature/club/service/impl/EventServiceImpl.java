package com.agiles.UniChain.feature.club.service.impl;

import com.agiles.UniChain.config.image.service.CloudneryImageService;
import com.agiles.UniChain.feature.club.entity.Club;
import com.agiles.UniChain.feature.club.entity.Event;
import com.agiles.UniChain.feature.club.payload.request.EventRequestDto;
import com.agiles.UniChain.feature.club.payload.response.EventResponseDto;
import com.agiles.UniChain.feature.club.repository.ClubRepository;
import com.agiles.UniChain.feature.club.repository.EventRepository;
import com.agiles.UniChain.feature.club.service.EventService;
import com.agiles.UniChain.feature.student.payload.request.StudentRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class EventServiceImpl extends AbstractService<Event, EventRequestDto, GenericSearchDto> implements EventService {

    EventRepository eventRepository;
    ClubRepository clubRepository;

    @Autowired
    private CloudneryImageService cloudneryImageService;

    public EventServiceImpl(AbstractRepository<Event> repository,EventRepository eventRepository, ClubRepository clubRepository) {
        super(repository);
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    protected EventResponseDto convertToResponseDto(Event event) {
        EventResponseDto responseDto = new EventResponseDto();
        responseDto.setId(event.getId());
        responseDto.setTitle(event.getTitle());
        responseDto.setDescription(event.getDescription());
        responseDto.setStartTime(event.getStartTime());
        responseDto.setEndTime(event.getEndTime());
        responseDto.setLocation(event.getLocation());
        responseDto.setImageUrl(event.getImageUrl());
        return responseDto;
    }

    @Override
    protected Event convertToEntity(EventRequestDto eventRequestDto) throws IOException {
        return updateEntity(eventRequestDto, new Event());
    }

    @Override
    protected Event updateEntity(EventRequestDto eventRequestDto, Event entity) throws IOException {

        MultipartFile file = eventRequestDto.getImageUrl();
        if (file != null && !file.isEmpty()) {
            Map<String, Object> uploadResult = cloudneryImageService.upload(file);
            entity.setImageUrl((String) uploadResult.get("secure_url"));
        }


        entity.setTitle(eventRequestDto.getTitle());
        entity.setDescription(eventRequestDto.getDescription());
        entity.setStartTime(eventRequestDto.getStartTime());
        entity.setEndTime(eventRequestDto.getEndTime());
        entity.setLocation(eventRequestDto.getLocation());


        if (eventRequestDto.getClubId() != null) {
            Club club = clubRepository.findById(eventRequestDto.getClubId())
                    .orElseThrow(() -> new RuntimeException("Club not found with ID: " + eventRequestDto.getClubId()));
            entity.setClub(club);
        }

        return entity;
    }

    @Override
    protected Specification<Event> buildSpecification(GenericSearchDto searchDto) {

        return null;
    }

    @Override
    public void createUpdated(EventRequestDto eventRequestDto, MultipartFile image) throws IOException {

        Event entity = new Event();

        if (image != null && !image.isEmpty()) {
            Map<String, Object> uploadResult = cloudneryImageService.upload(image);
            entity.setImageUrl((String) uploadResult.get("secure_url"));
        }


        entity.setTitle(eventRequestDto.getTitle());
        entity.setDescription(eventRequestDto.getDescription());
        entity.setStartTime(eventRequestDto.getStartTime());
        entity.setEndTime(eventRequestDto.getEndTime());
        entity.setLocation(eventRequestDto.getLocation());


        if (eventRequestDto.getClubId() != null) {
            Club club = clubRepository.findById(eventRequestDto.getClubId())
                    .orElseThrow(() -> new RuntimeException("Club not found with ID: " + eventRequestDto.getClubId()));
            entity.setClub(club);
        }

        eventRepository.save(entity);
    }
}
