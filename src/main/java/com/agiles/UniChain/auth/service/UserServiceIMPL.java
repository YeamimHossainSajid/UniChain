package com.agiles.UniChain.auth.service;

import com.agiles.UniChain.auth.dto.request.UserRequestDTO;
import com.agiles.UniChain.auth.dto.request.UserRoleRequestDTO;
import com.agiles.UniChain.auth.dto.response.CustomUserResponseDTO;
import com.agiles.UniChain.auth.model.Role;
import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.auth.repository.RoleRepo;
import com.agiles.UniChain.auth.repository.UserRepo;
import com.agiles.UniChain.config.image.service.CloudneryImageService;
import com.agiles.UniChain.config.mail.EmailService;
import com.agiles.UniChain.config.mail.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
public class UserServiceIMPL implements UserService {

    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepository;

    @Autowired
    private OtpService otpService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CloudneryImageService cloudneryImageService;

    private User tempUser;

    public UserServiceIMPL(UserRepo userRepo, PasswordEncoder passwordEncoder, RoleRepo roleRepository) {
        this.userRepository = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User ConvertToEntity(User user, UserRequestDTO userRequestDTO) {
        user.setUsername(userRequestDTO.username());
        user.setEmail(userRequestDTO.email());
        user.setPassword(passwordEncoder.encode(userRequestDTO.password()));
        return user;
    }

    public String create(UserRequestDTO requestDto) {
        if (userRepository.findByUsername(requestDto.username()) != null) {
            throw new RuntimeException("User already exists");
        }

        String generatedOtp = otpService.generateOtp(requestDto.email());
        emailService.sendOtpEmail(requestDto.email(), generatedOtp);

        tempUser = ConvertToEntity(new User(), requestDto);

        return "OTP sent to email. Please verify before proceeding.";
    }


    public String validateOtp(String email, String otp) {
        if (!otpService.verifyOtp(email, otp)) {
            return "Invalid OTP! Please try again.";
        }

        if (tempUser == null || !tempUser.getEmail().equals(email)) {
            return "No user data found. Please register again.";
        }

        userRepository.save(tempUser);
        otpService.removeOtp(email);
        tempUser = null;

        return "User registered successfully!";
    }


    public CustomUserResponseDTO readOne(Long id) {
        CustomUserResponseDTO singleUserById = userRepository.findUserByUserId(id);
        if (Objects.isNull(singleUserById)) {
            throw new RuntimeException("User with id " + id + " not found.");
        }
        return singleUserById;
    }


    public User setUserRoles(UserRoleRequestDTO requestDTO) {
        User foundUser = userRepository.findById(requestDTO.userId()).orElse(null);

        if (foundUser == null) {
            throw new RuntimeException("User with id " + requestDTO.userId() + " not found.");
        }

        Set<Role> foundRoles = roleRepository.findAllByIdIn(requestDTO.roleIds());
        foundUser.getRoles().addAll(foundRoles);

        return userRepository.save(foundUser);
    }

    @Override
    public void updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User with id " + id + " not found.")
        );

        User updateUser = ConvertToEntity(user, userRequestDTO);
        userRepository.save(updateUser);
    }

    @Override
    public CustomUserResponseDTO searchByUsername(String username) {
        return userRepository.searchByUsername(username);
    }
}
