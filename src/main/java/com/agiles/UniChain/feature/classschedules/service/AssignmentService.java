package com.agiles.UniChain.feature.classschedules.service;

import com.agiles.UniChain.feature.classschedules.entity.Assignment;
import com.agiles.UniChain.feature.classschedules.payload.request.AssignmentRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AssignmentService extends IService<Assignment, AssignmentRequestDto, GenericSearchDto> {

    public void createV2(AssignmentRequestDto assignmentRequestDto, MultipartFile file) throws IOException;

}
