package com.agiles.UniChain.feature.student.service.impl;

import com.agiles.UniChain.auth.dto.response.CustomUserResponseDTO;
import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.auth.repository.UserRepo;
import com.agiles.UniChain.config.image.service.CloudneryImageService;
import com.agiles.UniChain.feature.student.entity.Student;
import com.agiles.UniChain.feature.student.payload.request.StudentRequestDto;
import com.agiles.UniChain.feature.student.payload.response.StudentResponseDto;
import com.agiles.UniChain.feature.student.repository.StudentRepository;
import com.agiles.UniChain.feature.student.service.StudentService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl extends AbstractService<Student, StudentRequestDto, GenericSearchDto> implements StudentService {

    @Autowired
    CloudneryImageService cloudneryImageService;
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepo userRepo;

    public StudentServiceImpl(AbstractRepository<Student> repository) {
        super(repository);
    }


    @Override
    protected StudentResponseDto convertToResponseDto(Student student) {
        StudentResponseDto responseDto = new StudentResponseDto();
        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setPhoneNumber(student.getPhoneNumber());
        responseDto.setDepartment(student.getDepartment());
        responseDto.setMajor(student.getMajor());
        responseDto.setBatch(student.getBatch());
        responseDto.setSemester(student.getSemester());
        responseDto.setCgpa(student.getCgpa());
        responseDto.setInterests(student.getInterests());
        responseDto.setFuturePlans(student.getFuturePlans());
        responseDto.setProfileImage(student.getProfileImage());

        if (student.getUser() != null) {
            responseDto.setUser(new CustomUserResponseDTO() {
                @Override
                public Long getId() {
                    return student.getUser().getId();
                }
                @Override
                public String getUsername() {
                    return student.getUser().getUsername();
                }

                @Override
                public String getEmail() {
                    return student.getUser().getEmail();
                }

                @Override
                public StudentInfo getStudent() {
                    return new StudentInfo() {
                        @Override
                        public Long getId() {
                            return student.getId(); // Return the student ID
                        }
                    };
                }
                @Override
                public Set<RoleInfo> getRoles() {
                    return student.getUser().getRoles().stream().map(role -> new RoleInfo() {
                        @Override
                        public Long getId() {
                            return role.getId();
                        }

                        @Override
                        public String getRoleType() {
                            return role.getRoleType();
                        }
                    }).collect(Collectors.toSet());
                }
            });
        }
        return responseDto;
    }

    @Override
    protected Student convertToEntity(StudentRequestDto studentRequestDto) throws IOException {
        return updateEntity(studentRequestDto, new Student());
    }

    @Override
    protected Student updateEntity(StudentRequestDto studentRequestDto, Student entity) throws IOException {
        entity.setName(studentRequestDto.getName());
        entity.setPhoneNumber(studentRequestDto.getPhoneNumber());
        entity.setDepartment(studentRequestDto.getDepartment());
        entity.setMajor(studentRequestDto.getMajor());
        entity.setBatch(studentRequestDto.getBatch());
        entity.setSemester(studentRequestDto.getSemester());
        entity.setCgpa(studentRequestDto.getCgpa());
        entity.setInterests(studentRequestDto.getInterests());
        entity.setFuturePlans(studentRequestDto.getFuturePlans());
        entity.setUser(userRepo.findById(studentRequestDto.getUserId()).orElse(null));

        return entity;
    }

    @Override
    protected Specification<Student> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }

    @Override
    public void createUpdated(StudentRequestDto studentRequestDto, MultipartFile image) throws IOException {
        // Create a new Student entity
        Student student = new Student();

        // Set the profile image URL (default or uploaded)
        String profileImageUrl = "https://res.cloudinary.com/dxmwiwy6g/image/upload/v1740298839/jhp0yhawmfwffy195dn8.jpg";
        if (image != null && !image.isEmpty()) {
            Map<String, Object> uploadResult = cloudneryImageService.upload(image);
            profileImageUrl = (String) uploadResult.get("secure_url");
        }
        student.setProfileImage(profileImageUrl);

        // Set other fields from the request DTO
        student.setName(studentRequestDto.getName());
        student.setPhoneNumber(studentRequestDto.getPhoneNumber());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMajor(studentRequestDto.getMajor());
        student.setBatch(studentRequestDto.getBatch());
        student.setSemester(studentRequestDto.getSemester());
        student.setCgpa(studentRequestDto.getCgpa());
        student.setInterests(studentRequestDto.getInterests());
        student.setFuturePlans(studentRequestDto.getFuturePlans());

        // Fetch the User entity using the userId from the request DTO
        User user = userRepo.findById(studentRequestDto.getUserId()).orElse(null);
        if (user != null) {
            // Set the User in the Student entity
            student.setUser(user);

            // Set the Student in the User entity to maintain the bidirectional relationship
            user.setStudent(student);
        }

        // Save the Student entity
        studentRepository.save(student);

        // Save the User entity to update the student_id in the User table
        if (user != null) {
            userRepo.save(user);
        }
        studentRepository.save(student);
    }
}