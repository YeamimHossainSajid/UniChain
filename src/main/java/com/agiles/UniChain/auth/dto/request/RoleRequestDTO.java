package com.agiles.UniChain.auth.dto.request;


import java.io.Serializable;

public record RoleRequestDTO(

        String roleType

)
        implements Serializable {
}
