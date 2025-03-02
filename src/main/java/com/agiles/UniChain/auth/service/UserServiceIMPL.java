package com.agiles.UniChain.auth.service;

import com.agiles.UniChain.auth.dto.request.UserRequestDTO;
import com.agiles.UniChain.auth.dto.request.UserRoleRequestDTO;

import com.agiles.UniChain.auth.dto.response.CustomUserResponseDTO;
import com.agiles.UniChain.auth.model.Role;
import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.auth.repository.RoleRepo;
import com.agiles.UniChain.auth.repository.UserRepo;
import com.agiles.UniChain.config.image.service.CloudneryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Objects;
import java.util.Set;

@Service

public class UserServiceIMPL implements UserService {

    private UserRepo userRepository;
    private  PasswordEncoder passwordEncoder;
    private RoleRepo roleRepository;

    @Autowired
    private CloudneryImageService cloudneryImageService;

   public UserServiceIMPL(UserRepo userRepo,PasswordEncoder passwordEncoder,RoleRepo roleRepository) {
       this.userRepository = userRepo;
       this.passwordEncoder = passwordEncoder;
       this.roleRepository = roleRepository;
   }


   public User ConvertToEntity(User user, UserRequestDTO userRequestDTO){

       user.setUsername( userRequestDTO.username() );
       user.setEmail( userRequestDTO.email() );
       user.setPassword( passwordEncoder.encode(userRequestDTO.password() ));

       return user;
   }




    public void create(UserRequestDTO requestDto) {
       User user1=userRepository.findByUsername(requestDto.username());
       if(user1!=null){
           throw new RuntimeException("User already exists");
       }

       User user = ConvertToEntity(new User(), requestDto);

       userRepository.save(user);


    }


    public CustomUserResponseDTO readOne(Long id ) {
        CustomUserResponseDTO singleUserById = userRepository.findUserByUserId(id);
        if ( Objects.isNull( singleUserById ) ) {
            throw new RuntimeException( "User with id " + id + " not found." );
        }
        return singleUserById;
    }


    public User setUserRoles( UserRoleRequestDTO requestDTO ) {

        User foundUser = userRepository.findById( requestDTO.userId() ).get();

        if ( Objects.isNull( foundUser ) ) {
            throw new RuntimeException( "User with id " + requestDTO.userId() + " not found." );
        }

        Set<Role> foundRoles = roleRepository.findAllByIdIn( requestDTO.roleIds() );
        foundUser.getRoles().addAll( foundRoles );

        return  userRepository.save( foundUser );

    }


    @Override
    public void updateUser(Long id, UserRequestDTO userRequestDTO){

       User user=userRepository.findById( id ).get();

       User updateUser = ConvertToEntity(user, userRequestDTO);

       userRepository.save( updateUser );

    }

    @Override
    public CustomUserResponseDTO searchByUsername(String username) {
        return userRepository.searchByUsername( username );
    }



}
