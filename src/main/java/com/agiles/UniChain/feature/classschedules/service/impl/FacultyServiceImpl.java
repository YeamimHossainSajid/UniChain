package com.agiles.UniChain.feature.classschedules.service.impl;

import com.agiles.UniChain.feature.classschedules.entity.Faculty;
import com.agiles.UniChain.feature.classschedules.entity.Course;
import com.agiles.UniChain.feature.classschedules.payload.request.FacultyRequestDto;
import com.agiles.UniChain.feature.classschedules.payload.response.CourseResponseDto;
import com.agiles.UniChain.feature.classschedules.payload.response.FacultyResponseDto;
import com.agiles.UniChain.feature.classschedules.repository.CourseRepository;
import com.agiles.UniChain.feature.classschedules.service.FacultyService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl extends AbstractService<Faculty, FacultyRequestDto, GenericSearchDto> implements FacultyService {

    @Autowired
    private CourseRepository courseRepository;

    public FacultyServiceImpl(AbstractRepository<Faculty> repository) {
        super(repository);
    }

    @Override
    protected FacultyResponseDto convertToResponseDto(Faculty faculty) {
        FacultyResponseDto responseDto = new FacultyResponseDto();
        responseDto.setId(faculty.getId());
        responseDto.setName(faculty.getName());
        responseDto.setEmail(faculty.getEmail());
        responseDto.setPhone(faculty.getPhone());
        responseDto.setDepartment(faculty.getDepartment());
        responseDto.setOfficeHours(faculty.getOfficeHours());
        responseDto.setImage(faculty.getImage());

        List<CourseResponseDto> courseResponseDtos = faculty.getCourses().stream()
                .map(course -> {
                    CourseResponseDto courseDto = new CourseResponseDto();
                    courseDto.setId(course.getId());
                    courseDto.setName(course.getName());
                    courseDto.setCode(course.getCode());
                    return courseDto;
                })
                .toList();
        responseDto.setCourses(courseResponseDtos);

        return responseDto;
    }

    @Override
    protected Faculty convertToEntity(FacultyRequestDto facultyRequestDto) throws IOException {
        return updateEntity(facultyRequestDto, new Faculty());
    }

    @Override
    protected Faculty updateEntity(FacultyRequestDto facultyRequestDto, Faculty entity) throws IOException {
        entity.setName(facultyRequestDto.getName());
        entity.setEmail(facultyRequestDto.getEmail());
        entity.setPhone(facultyRequestDto.getPhone());
        entity.setDepartment(facultyRequestDto.getDepartment());
        entity.setOfficeHours(facultyRequestDto.getOfficeHours());


        MultipartFile imageFile = facultyRequestDto.getImage();
        if (imageFile != null && !imageFile.isEmpty()) {
            entity.setImage(imageFile.getOriginalFilename());
        }

        return entity;
    }

    @Override
    protected Specification<Faculty> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
