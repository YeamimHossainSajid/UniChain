package com.agiles.UniChain.feature.classschedules.service.impl;

import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.auth.repository.UserRepo;
import com.agiles.UniChain.config.mail.EmailService;
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
import org.hibernate.annotations.AttributeAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExamScheduleServiceImpl extends AbstractService<ExamSchedule, ExamScheduleRequestDto, GenericSearchDto> implements ExamScheduleService {

    private final CourseRepository courseRepository;

    @Autowired
    EmailService emailService;
    @Autowired
    UserRepo userRepo;
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
        List<User> users = userRepo.findAll();
        String examTitle = examScheduleRequestDto.getLocation();
        Long examDate = examScheduleRequestDto.getCourseId();
        LocalDate localDate = examScheduleRequestDto.getDate();


        for (User user : users) {
            String userEmail = user.getEmail();

            if (isValidEmail(userEmail)) {
                emailService.sendUpcomingExamScheduleEmail(userEmail, examTitle, examDate,localDate);
            } else {
                System.out.println("Skipping invalid email: " + userEmail);
            }
        }

        return updateEntity(examScheduleRequestDto, new ExamSchedule());
    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
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

