package com.agiles.UniChain.feature.club.service.impl;

import com.agiles.UniChain.feature.club.entity.Club;
import com.agiles.UniChain.feature.club.payload.request.ClubRequestDto;
import com.agiles.UniChain.feature.club.service.ClubService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;

public class ClubServiceImpl extends AbstractService<Club, ClubRequestDto, GenericSearchDto> implements ClubService {

    public ClubServiceImpl(AbstractRepository<Club> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(Club club) {
        return null;
    }

    @Override
    protected Club convertToEntity(ClubRequestDto clubRequestDto) throws IOException {
        return null;
    }

    @Override
    protected Club updateEntity(ClubRequestDto clubRequestDto, Club entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<Club> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
