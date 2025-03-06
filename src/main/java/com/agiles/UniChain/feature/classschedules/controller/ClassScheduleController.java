package com.agiles.UniChain.feature.classschedules.controller;

import com.agiles.UniChain.feature.classschedules.entity.Assignment;
import com.agiles.UniChain.feature.classschedules.entity.ClassSchedule;
import com.agiles.UniChain.feature.classschedules.payload.request.AssignmentRequestDto;
import com.agiles.UniChain.feature.classschedules.payload.request.ClassScheduleRequestDto;
import com.agiles.UniChain.feature.classschedules.service.AssignmentService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.AbstractService;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ClassSchedule")
public class ClassScheduleController extends AbstractController<ClassSchedule, ClassScheduleRequestDto, GenericSearchDto> {

    public ClassScheduleController(IService<ClassSchedule, ClassScheduleRequestDto, GenericSearchDto> service) {
        super(service);
    }
}
