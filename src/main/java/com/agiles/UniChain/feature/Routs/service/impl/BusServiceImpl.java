package com.agiles.UniChain.feature.Routs.service.impl;

import com.agiles.UniChain.feature.Routs.entity.Bus;
import com.agiles.UniChain.feature.Routs.payload.request.BusRequestDTO;
import com.agiles.UniChain.feature.Routs.service.BusService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;

public class BusServiceImpl extends AbstractService<Bus, BusRequestDTO, GenericSearchDto> implements BusService {

    public BusServiceImpl(AbstractRepository<Bus> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(Bus bus) {
        return null;
    }

    @Override
    protected Bus convertToEntity(BusRequestDTO busRequestDTO) throws IOException {
        return null;
    }

    @Override
    protected Bus updateEntity(BusRequestDTO busRequestDTO, Bus entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<Bus> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
