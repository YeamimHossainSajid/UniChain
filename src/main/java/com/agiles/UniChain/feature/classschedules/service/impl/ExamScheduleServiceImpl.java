package com.agiles.UniChain.feature.classschedules.service.impl;

import com.agiles.UniChain.feature.classschedules.entity.ExamSchedule;
import com.agiles.UniChain.feature.classschedules.payload.request.ExamScheduleRequestDto;
import com.agiles.UniChain.feature.classschedules.service.ExamScheduleService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExamScheduleServiceImpl extends AbstractService<ExamSchedule, ExamScheduleRequestDto, GenericSearchDto> implements ExamScheduleService {
    public ExamScheduleServiceImpl(AbstractRepository<ExamSchedule> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(ExamSchedule examSchedule) {
        return null;
    }

    @Override
    protected ExamSchedule convertToEntity(ExamScheduleRequestDto examScheduleRequestDto) throws IOException {
        return null;
    }

    @Override
    protected ExamSchedule updateEntity(ExamScheduleRequestDto examScheduleRequestDto, ExamSchedule entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<ExamSchedule> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
