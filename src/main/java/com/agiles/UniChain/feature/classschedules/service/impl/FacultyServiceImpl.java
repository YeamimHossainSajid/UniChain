package com.agiles.UniChain.feature.classschedules.service.impl;

import com.agiles.UniChain.feature.classschedules.entity.Faculty;
import com.agiles.UniChain.feature.classschedules.payload.request.FacultyRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FacultyServiceImpl extends AbstractService<Faculty, FacultyRequestDto, GenericSearchDto> {
    public FacultyServiceImpl(AbstractRepository<Faculty> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(Faculty faculty) {
        return null;
    }

    @Override
    protected Faculty convertToEntity(FacultyRequestDto facultyRequestDto) throws IOException {
        return null;
    }

    @Override
    protected Faculty updateEntity(FacultyRequestDto facultyRequestDto, Faculty entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<Faculty> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
