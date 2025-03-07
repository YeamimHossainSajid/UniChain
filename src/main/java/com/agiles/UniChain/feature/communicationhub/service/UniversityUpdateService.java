package com.agiles.UniChain.feature.communicationhub.service;

import com.agiles.UniChain.feature.communicationhub.entity.UniversityUpdate;
import com.agiles.UniChain.feature.communicationhub.payload.request.UniversityUpdateRequest;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface UniversityUpdateService extends IService<UniversityUpdate, UniversityUpdateRequest, GenericSearchDto> {
}
