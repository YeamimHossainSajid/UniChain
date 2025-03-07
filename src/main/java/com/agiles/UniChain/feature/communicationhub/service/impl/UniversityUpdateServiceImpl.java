package com.agiles.UniChain.feature.communicationhub.service.impl;

import com.agiles.UniChain.feature.communicationhub.entity.UniversityUpdate;
import com.agiles.UniChain.feature.communicationhub.payload.request.UniversityUpdateRequest;
import com.agiles.UniChain.feature.communicationhub.payload.response.UniversityUpdateResponse;
import com.agiles.UniChain.feature.communicationhub.service.UniversityUpdateService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UniversityUpdateServiceImpl extends AbstractService<UniversityUpdate, UniversityUpdateRequest, GenericSearchDto> implements UniversityUpdateService {

    public UniversityUpdateServiceImpl(AbstractRepository<UniversityUpdate> repository) {
        super(repository);
    }

    @Override
    protected UniversityUpdateResponse convertToResponseDto(UniversityUpdate universityUpdate) {
        UniversityUpdateResponse response = new UniversityUpdateResponse();
        response.setDescription(universityUpdate.getDescription());
        response.setTime(universityUpdate.getTime());
        return response;
    }

    @Override
    protected UniversityUpdate convertToEntity(UniversityUpdateRequest universityUpdateRequest) throws IOException {
        return updateEntity(universityUpdateRequest,new UniversityUpdate());
    }

    @Override
    protected UniversityUpdate updateEntity(UniversityUpdateRequest universityUpdateRequest, UniversityUpdate entity) throws IOException {
        entity.setDescription(universityUpdateRequest.getDescription());
        entity.setTime(universityUpdateRequest.getTime());
        return entity;
    }

    @Override
    protected Specification<UniversityUpdate> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
