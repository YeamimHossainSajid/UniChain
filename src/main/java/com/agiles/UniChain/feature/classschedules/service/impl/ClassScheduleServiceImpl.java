package com.agiles.UniChain.feature.classschedules.service.impl;

import com.agiles.UniChain.feature.classschedules.entity.ClassSchedule;
import com.agiles.UniChain.feature.classschedules.payload.request.ClassScheduleRequestDto;
import com.agiles.UniChain.feature.classschedules.service.ClassScheduleService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ClassScheduleServiceImpl extends AbstractService<ClassSchedule, ClassScheduleRequestDto, GenericSearchDto> implements ClassScheduleService {
    public ClassScheduleServiceImpl(AbstractRepository<ClassSchedule> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(ClassSchedule classSchedule) {
        return null;
    }

    @Override
    protected ClassSchedule convertToEntity(ClassScheduleRequestDto classScheduleRequestDto) throws IOException {
        return null;
    }

    @Override
    protected ClassSchedule updateEntity(ClassScheduleRequestDto classScheduleRequestDto, ClassSchedule entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<ClassSchedule> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
