package com.agiles.UniChain.auth.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record UserUpdateRequestDto(

        MultipartFile profilpic,

        String address,

        String phone,

        String bio,

        Long sold,

        Long propertyAdded,

        String profession,

        String fullname
) {

}
