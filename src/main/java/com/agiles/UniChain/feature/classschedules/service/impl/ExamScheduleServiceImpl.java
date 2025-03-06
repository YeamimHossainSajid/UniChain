package com.agiles.UniChain.feature.classschedules.service.impl;

import com.agiles.UniChain.feature.classschedules.entity.ExamSchedule;
import com.agiles.UniChain.feature.classschedules.entity.Course;
import com.agiles.UniChain.feature.classschedules.payload.request.ExamScheduleRequestDto;
import com.agiles.UniChain.feature.classschedules.payload.response.CourseResponseDto;
import com.agiles.UniChain.feature.classschedules.payload.response.ExamScheduleResponseDto;
import com.agiles.UniChain.feature.classschedules.repository.CourseRepository;
import com.agiles.UniChain.feature.classschedules.service.ExamScheduleService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class ExamScheduleServiceImpl extends AbstractService<ExamSchedule, ExamScheduleRequestDto, GenericSearchDto> implements ExamScheduleService {

    private final CourseRepository courseRepository;

    @Autowired
    public ExamScheduleServiceImpl(AbstractRepository<ExamSchedule> repository, CourseRepository courseRepository) {
        super(repository);
        this.courseRepository = courseRepository;
    }

    @Override
    protected ExamScheduleResponseDto convertToResponseDto(ExamSchedule examSchedule) {
        ExamScheduleResponseDto responseDto = new ExamScheduleResponseDto();
        responseDto.setId(examSchedule.getId());
        responseDto.setDate(examSchedule.getDate());
        responseDto.setTime(examSchedule.getTime());
        responseDto.setLocation(examSchedule.getLocation());

        if (examSchedule.getCourse() != null) {
            CourseResponseDto courseResponseDto = new CourseResponseDto();
            courseResponseDto.setId(examSchedule.getCourse().getId());
            courseResponseDto.setName(examSchedule.getCourse().getName());
            courseResponseDto.setCode(examSchedule.getCourse().getCode());
            responseDto.setCourse(courseResponseDto);
        }

        return responseDto;
    }

    @Override
    protected ExamSchedule convertToEntity(ExamScheduleRequestDto examScheduleRequestDto) throws IOException {
        return updateEntity(examScheduleRequestDto, new ExamSchedule());
    }

    @Override
    protected ExamSchedule updateEntity(ExamScheduleRequestDto examScheduleRequestDto, ExamSchedule entity) throws IOException {
        entity.setDate(examScheduleRequestDto.getDate());
        entity.setTime(examScheduleRequestDto.getTime());
        entity.setLocation(examScheduleRequestDto.getLocation());

        if (examScheduleRequestDto.getCourseId() != null) {
            Optional<Course> courseOptional = courseRepository.findById(examScheduleRequestDto.getCourseId());
            if (courseOptional.isPresent()) {
                entity.setCourse(courseOptional.get());
            } else {
                throw new IOException("Course not found with ID: " + examScheduleRequestDto.getCourseId());
            }
        }

        return entity;
    }

    @Override
    protected Specification<ExamSchedule> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}

