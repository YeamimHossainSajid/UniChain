package com.agiles.UniChain.auth.service;


import com.agiles.UniChain.auth.dto.response.CustomRoleResponseDTO;

public interface RoleService {

    public CustomRoleResponseDTO readOne(Long id );
    public String delete( Long id );

}
