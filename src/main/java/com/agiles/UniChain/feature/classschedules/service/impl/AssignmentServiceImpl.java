package com.agiles.UniChain.feature.classschedules.service.impl;

import com.agiles.UniChain.config.image.service.CloudneryImageService;
import com.agiles.UniChain.feature.classschedules.entity.Assignment;
import com.agiles.UniChain.feature.classschedules.entity.Course;
import com.agiles.UniChain.feature.classschedules.payload.request.AssignmentRequestDto;
import com.agiles.UniChain.feature.classschedules.payload.response.AssignmentResponseDto;
import com.agiles.UniChain.feature.classschedules.repository.CourseRepository;
import com.agiles.UniChain.feature.classschedules.service.AssignmentService;
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
public class AssignmentServiceImpl extends AbstractService<Assignment, AssignmentRequestDto, GenericSearchDto> implements AssignmentService {

    @Autowired
    private CloudneryImageService cloudneryImageService;

    @Autowired
 CourseRepository courseRepository;

    public AssignmentServiceImpl(AbstractRepository<Assignment> repository) {
        super(repository);
    }

    @Override
    protected AssignmentResponseDto convertToResponseDto(Assignment assignment) {
        AssignmentResponseDto responseDto = new AssignmentResponseDto();
        responseDto.setTitle(assignment.getTitle());
        responseDto.setDueDate(assignment.getDueDate());
        responseDto.setStatus(assignment.getStatus());
        responseDto.setImage(assignment.getImage());
        return responseDto;
    }

    @Override
    protected Assignment convertToEntity(AssignmentRequestDto assignmentRequestDto) throws IOException {
        return updateEntity(assignmentRequestDto, new Assignment());
    }

    @Override
    protected Assignment updateEntity(AssignmentRequestDto assignmentRequestDto, Assignment entity) throws IOException {
        MultipartFile file = assignmentRequestDto.getImage();
        if (file != null && !file.isEmpty()) {
            Map<String, Object> heroUploadResult = cloudneryImageService.upload(file);
            String imageUrl = (String) heroUploadResult.get("secure_url");
            entity.setImage(imageUrl);
        }

        entity.setTitle(assignmentRequestDto.getTitle());
        entity.setDueDate(assignmentRequestDto.getDueDate());
        entity.setStatus(assignmentRequestDto.getStatus());

        if (assignmentRequestDto.getCourseId() != null) {
            Course course = courseRepository.findById(assignmentRequestDto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with ID: " + assignmentRequestDto.getCourseId()));
            entity.setCourse(course);
        }

        return entity;
    }

    @Override
    protected Specification<Assignment> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}

