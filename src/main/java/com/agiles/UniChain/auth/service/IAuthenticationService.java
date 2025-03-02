package com.agiles.UniChain.auth.service;


import com.agiles.UniChain.auth.dto.request.LoginRequestDTO;
import com.agiles.UniChain.auth.dto.response.LoginResponseDTO;

public interface IAuthenticationService {
    LoginResponseDTO login(LoginRequestDTO requestDTO );
}
