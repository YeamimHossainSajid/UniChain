package com.agiles.UniChain.feature.classschedules.service.impl;

import com.agiles.UniChain.feature.classschedules.entity.Course;
import com.agiles.UniChain.feature.classschedules.entity.Faculty;
import com.agiles.UniChain.feature.classschedules.payload.request.CourseRequestDto;
import com.agiles.UniChain.feature.classschedules.payload.response.*;
import com.agiles.UniChain.feature.classschedules.repository.FacultyRepository;
import com.agiles.UniChain.feature.classschedules.service.CourseService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl extends AbstractService<Course, CourseRequestDto, GenericSearchDto> implements CourseService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public CourseServiceImpl(AbstractRepository<Course> repository, FacultyRepository facultyRepository) {
        super(repository);
        this.facultyRepository = facultyRepository;
    }

    @Override
    protected CourseResponseDto convertToResponseDto(Course course) {
        CourseResponseDto responseDto = new CourseResponseDto();
        responseDto.setId(course.getId());
        responseDto.setName(course.getName());
        responseDto.setCode(course.getCode());

        if (course.getFaculty() != null) {
            FacultyResponseDto facultyResponseDto = new FacultyResponseDto();
            facultyResponseDto.setId(course.getFaculty().getId());
            facultyResponseDto.setName(course.getFaculty().getName());
            responseDto.setFaculty(facultyResponseDto);
        }

        responseDto.setClassSchedules(course.getClassSchedules().stream()
                .map(classSchedule -> {
                    ClassScheduleResponseDto classScheduleResponseDto = new ClassScheduleResponseDto();
                    classScheduleResponseDto.setDay(classSchedule.getDay());
                    classScheduleResponseDto.setTime(classSchedule.getTime());
                    classScheduleResponseDto.setLocation(classSchedule.getLocation());
                    classScheduleResponseDto.setReminderTime(classSchedule.getReminderTime());
                    return classScheduleResponseDto;
                })
                .collect(Collectors.toList()));

        responseDto.setAssignments(course.getAssignments().stream()
                .map(assignment -> {
                    AssignmentResponseDto assignmentResponseDto = new AssignmentResponseDto();
                    assignmentResponseDto.setTitle(assignment.getTitle());
                    assignmentResponseDto.setDueDate(assignment.getDueDate());
                    assignmentResponseDto.setStatus(assignment.getStatus());
                    assignmentResponseDto.setImage(assignment.getImage());
                    return assignmentResponseDto;
                })
                .collect(Collectors.toList()));

        responseDto.setExamSchedules(course.getExamSchedules().stream()
                .map(examSchedule -> {
                    ExamScheduleResponseDto examScheduleResponseDto = new ExamScheduleResponseDto();
                    examScheduleResponseDto.setId(examSchedule.getId());
                    examScheduleResponseDto.setDate(examSchedule.getDate());
                    examScheduleResponseDto.setTime(examSchedule.getTime());
                    examScheduleResponseDto.setLocation(examSchedule.getLocation());

                    CourseResponseDto examCourseResponseDto = new CourseResponseDto();
                    examCourseResponseDto.setId(examSchedule.getCourse().getId());
                    examCourseResponseDto.setName(examSchedule.getCourse().getName());
                    examCourseResponseDto.setCode(examSchedule.getCourse().getCode());
                    examScheduleResponseDto.setCourse(examCourseResponseDto);

                    return examScheduleResponseDto;
                })
                .collect(Collectors.toList()));

        return responseDto;
    }

    @Override
    protected Course convertToEntity(CourseRequestDto courseRequestDto) throws IOException {
        return updateEntity(courseRequestDto, new Course());
    }

    @Override
    protected Course updateEntity(CourseRequestDto courseRequestDto, Course entity) throws IOException {
        entity.setName(courseRequestDto.getName());
        entity.setCode(courseRequestDto.getCode());

        if (courseRequestDto.getFacultyId() != null) {
            Faculty faculty = facultyRepository.findById(courseRequestDto.getFacultyId())
                    .orElseThrow(() -> new RuntimeException("Faculty not found with ID: " + courseRequestDto.getFacultyId()));
            entity.setFaculty(faculty);
        }

        return entity;
    }

    @Override
    protected Specification<Course> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
