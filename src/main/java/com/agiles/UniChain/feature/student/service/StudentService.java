package com.agiles.UniChain.feature.student.service;

import com.agiles.UniChain.feature.student.entity.Student;
import com.agiles.UniChain.feature.student.payload.request.StudentRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface StudentService extends IService<Student, StudentRequestDto, GenericSearchDto> {
}
