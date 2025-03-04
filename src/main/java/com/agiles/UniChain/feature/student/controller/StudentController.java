package com.agiles.UniChain.feature.student.controller;

import com.agiles.UniChain.feature.student.entity.Student;
import com.agiles.UniChain.feature.student.payload.request.StudentRequestDto;
import com.agiles.UniChain.feature.student.service.StudentService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/student")
public class StudentController extends AbstractController<Student, StudentRequestDto, GenericSearchDto> {

    @Autowired
    StudentService studentService;
    public StudentController(IService<Student, StudentRequestDto, GenericSearchDto> service) {
        super(service);
    }
    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Override
    public ResponseEntity<String> create(@ModelAttribute StudentRequestDto dto) throws IOException {
        studentService.create(dto);
        return ResponseEntity.ok("Student created");
    }

    @PostMapping(value = "/updated/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> createUpdated(@ModelAttribute StudentRequestDto dto) throws IOException {
        MultipartFile picture =null;
        studentService.createUpdated(dto,picture);
        return ResponseEntity.ok("Student updated");
    }
}
