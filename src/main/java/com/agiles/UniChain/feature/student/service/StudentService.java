package com.agiles.UniChain.feature.student.service;

import com.agiles.UniChain.feature.student.entity.Student;
import com.agiles.UniChain.feature.student.payload.request.StudentRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StudentService extends IService<Student, StudentRequestDto, GenericSearchDto> {

    public void createUpdated(StudentRequestDto studentRequestDto, MultipartFile image) throws IOException;

}
