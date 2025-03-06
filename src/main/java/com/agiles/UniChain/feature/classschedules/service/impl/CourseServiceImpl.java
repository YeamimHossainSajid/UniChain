package com.agiles.UniChain.feature.classschedules.service.impl;

import com.agiles.UniChain.feature.classschedules.entity.Course;
import com.agiles.UniChain.feature.classschedules.payload.request.CourseRequestDto;
import com.agiles.UniChain.feature.classschedules.service.CourseService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CourseServiceImpl extends AbstractService<Course, CourseRequestDto, GenericSearchDto> implements CourseService {
    public CourseServiceImpl(AbstractRepository<Course> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(Course course) {
        return null;
    }

    @Override
    protected Course convertToEntity(CourseRequestDto courseRequestDto) throws IOException {
        return null;
    }

    @Override
    protected Course updateEntity(CourseRequestDto courseRequestDto, Course entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<Course> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
