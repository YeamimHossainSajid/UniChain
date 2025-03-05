package com.agiles.UniChain.feature.classschedules.service;

import com.agiles.UniChain.feature.classschedules.entity.ClassSchedule;
import com.agiles.UniChain.feature.classschedules.payload.request.ClassScheduleRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface ClassScheduleService extends IService<ClassSchedule, ClassScheduleRequestDto, GenericSearchDto> {
}
