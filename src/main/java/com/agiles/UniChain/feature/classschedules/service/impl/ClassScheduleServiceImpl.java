package com.agiles.UniChain.feature.classschedules.service.impl;

import com.agiles.UniChain.feature.classschedules.entity.ClassSchedule;
import com.agiles.UniChain.feature.classschedules.entity.Course;
import com.agiles.UniChain.feature.classschedules.payload.request.ClassScheduleRequestDto;
import com.agiles.UniChain.feature.classschedules.payload.response.ClassScheduleResponseDto;
import com.agiles.UniChain.feature.classschedules.repository.CourseRepository;
import com.agiles.UniChain.feature.classschedules.service.ClassScheduleService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ClassScheduleServiceImpl extends AbstractService<ClassSchedule, ClassScheduleRequestDto, GenericSearchDto> implements ClassScheduleService {

    private final CourseRepository courseRepository;

    @Autowired
    public ClassScheduleServiceImpl(AbstractRepository<ClassSchedule> repository, CourseRepository courseRepository) {
        super(repository);
        this.courseRepository = courseRepository;
    }

    @Override
    protected ClassScheduleResponseDto convertToResponseDto(ClassSchedule classSchedule) {
        ClassScheduleResponseDto responseDto = new ClassScheduleResponseDto();
        responseDto.setDay(classSchedule.getDay());
        responseDto.setTime(classSchedule.getTime());
        responseDto.setLocation(classSchedule.getLocation());
        responseDto.setReminderTime(classSchedule.getReminderTime());
        return responseDto;
    }

    @Override
    protected ClassSchedule convertToEntity(ClassScheduleRequestDto classScheduleRequestDto) throws IOException {
        return updateEntity(classScheduleRequestDto, new ClassSchedule());
    }

    @Override
    protected ClassSchedule updateEntity(ClassScheduleRequestDto classScheduleRequestDto, ClassSchedule entity) throws IOException {
        entity.setDay(classScheduleRequestDto.getDay());
        entity.setTime(classScheduleRequestDto.getTime());
        entity.setLocation(classScheduleRequestDto.getLocation());
        entity.setReminderTime(classScheduleRequestDto.getReminderTime());

        if (classScheduleRequestDto.getCourseId() != null) {
            Course course = courseRepository.findById(classScheduleRequestDto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with ID: " + classScheduleRequestDto.getCourseId()));
            entity.setCourse(course);
        }

        return entity;
    }

    @Override
    protected Specification<ClassSchedule> buildSpecification(GenericSearchDto searchDto) {
        return null; // Implement any custom specification logic if needed
    }
}
