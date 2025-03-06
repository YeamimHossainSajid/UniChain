package com.agiles.UniChain.feature.classschedules.controller;

import com.agiles.UniChain.feature.canteen.payload.request.FoodItemRequestDto;
import com.agiles.UniChain.feature.classschedules.entity.Course;
import com.agiles.UniChain.feature.classschedules.payload.request.AssignmentRequestDto;
import com.agiles.UniChain.feature.classschedules.payload.request.CourseRequestDto;
import com.agiles.UniChain.feature.classschedules.service.AssignmentService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("Assignment")
public class AssignmentController extends AbstractController<Course, CourseRequestDto, GenericSearchDto> {
   AssignmentService assignmentService;
    public AssignmentController(IService<Course, CourseRequestDto, GenericSearchDto> service,AssignmentService assignmentService) {
        super(service);
        this.assignmentService = assignmentService;
    }

    @PostMapping(value = "create/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> create(@ModelAttribute AssignmentRequestDto dto) throws IOException {
        MultipartFile imageFile = dto.getImage();
        assignmentService.createV2(dto,imageFile);
        return ResponseEntity.ok("Assignment Created Successfully");
    }
}
