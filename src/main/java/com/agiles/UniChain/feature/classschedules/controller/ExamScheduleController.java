package com.agiles.UniChain.feature.classschedules.controller;

import com.agiles.UniChain.feature.classschedules.entity.ExamSchedule;
import com.agiles.UniChain.feature.classschedules.payload.request.ExamScheduleRequestDto;
import com.agiles.UniChain.feature.classschedules.service.ExamScheduleService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public class ExamScheduleController extends AbstractController<ExamSchedule, ExamScheduleRequestDto, GenericSearchDto> {
    public ExamScheduleController(ExamScheduleService service) {
        super(service);
    }
}
