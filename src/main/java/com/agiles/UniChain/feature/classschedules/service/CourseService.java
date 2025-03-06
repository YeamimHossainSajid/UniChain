package com.agiles.UniChain.feature.classschedules.service;

import com.agiles.UniChain.feature.classschedules.entity.Course;
import com.agiles.UniChain.feature.classschedules.payload.request.CourseRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface CourseService extends IService<Course, CourseRequestDto, GenericSearchDto> {
}
