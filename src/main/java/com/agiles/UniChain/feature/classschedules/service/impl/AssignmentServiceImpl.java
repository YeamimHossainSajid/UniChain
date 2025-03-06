package com.agiles.UniChain.feature.classschedules.service.impl;

import com.agiles.UniChain.feature.classschedules.entity.Assignment;
import com.agiles.UniChain.feature.classschedules.payload.request.AssignmentRequestDto;
import com.agiles.UniChain.feature.classschedules.service.AssignmentService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AssignmentServiceImpl extends AbstractService<Assignment, AssignmentRequestDto, GenericSearchDto> implements AssignmentService{
    public AssignmentServiceImpl(AbstractRepository<Assignment> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(Assignment assignment) {
        return null;
    }

    @Override
    protected Assignment convertToEntity(AssignmentRequestDto assignmentRequestDto) throws IOException {
        return null;
    }

    @Override
    protected Assignment updateEntity(AssignmentRequestDto assignmentRequestDto, Assignment entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<Assignment> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
