package com.agiles.UniChain.auth.controller;

import com.agiles.UniChain.auth.dto.request.LoginRequestDTO;
import com.agiles.UniChain.auth.dto.response.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationController {

    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO requestDTO );

}
