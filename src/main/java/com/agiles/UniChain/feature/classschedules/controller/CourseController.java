package com.agiles.UniChain.feature.classschedules.controller;

import com.agiles.UniChain.feature.classschedules.entity.Course;
import com.agiles.UniChain.feature.classschedules.payload.request.CourseRequestDto;
import com.agiles.UniChain.feature.classschedules.service.CourseService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public class CourseController extends AbstractController<Course, CourseRequestDto, GenericSearchDto> {
    public CourseController(CourseService service) {
        super(service);
    }
}
