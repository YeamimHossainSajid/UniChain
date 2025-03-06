package com.agiles.UniChain.feature.classschedules.service;

import com.agiles.UniChain.feature.classschedules.entity.ExamSchedule;
import com.agiles.UniChain.feature.classschedules.payload.request.ExamScheduleRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface ExamScheduleService extends IService<ExamSchedule, ExamScheduleRequestDto, GenericSearchDto> {
}
