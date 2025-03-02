package com.agiles.UniChain.auth.service;

import com.agiles.UniChain.auth.dto.request.UserRequestDTO;
import com.agiles.UniChain.auth.dto.request.UserRoleRequestDTO;
import com.agiles.UniChain.auth.dto.response.CustomUserResponseDTO;
import com.agiles.UniChain.auth.model.User;

public interface UserService {

    public void create(UserRequestDTO requestDto);
    public CustomUserResponseDTO readOne(Long id );
    public User setUserRoles(UserRoleRequestDTO requestDTO );
    public void updateUser(Long id, UserRequestDTO userRequestDTO);
    public CustomUserResponseDTO searchByUsername(String username);
}