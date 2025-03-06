package com.agiles.UniChain.feature.classschedules.service;

import com.agiles.UniChain.feature.classschedules.entity.Faculty;
import com.agiles.UniChain.feature.classschedules.payload.request.FacultyRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface FacultyService extends IService<Faculty, FacultyRequestDto, GenericSearchDto> {
}
