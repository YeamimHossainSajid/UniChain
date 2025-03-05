package com.agiles.UniChain.feature.classschedules.service;

import com.agiles.UniChain.feature.classschedules.entity.Assignment;
import com.agiles.UniChain.feature.classschedules.payload.request.AssignmentRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface AssignmentService extends IService<Assignment, AssignmentRequestDto, GenericSearchDto> {
}
