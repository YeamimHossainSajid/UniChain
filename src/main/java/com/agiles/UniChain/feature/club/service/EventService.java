package com.agiles.UniChain.feature.club.service;

import com.agiles.UniChain.feature.club.entity.Event;
import com.agiles.UniChain.feature.club.payload.request.EventRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface EventService extends IService<Event, EventRequestDto, GenericSearchDto> {
}
