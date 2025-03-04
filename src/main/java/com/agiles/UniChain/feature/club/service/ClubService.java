package com.agiles.UniChain.feature.club.service;

import com.agiles.UniChain.feature.club.entity.Club;
import com.agiles.UniChain.feature.club.payload.request.ClubRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface ClubService extends IService<Club, ClubRequestDto, GenericSearchDto> {
}
