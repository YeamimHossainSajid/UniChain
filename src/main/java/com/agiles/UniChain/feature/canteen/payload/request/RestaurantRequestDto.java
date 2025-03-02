package com.agiles.UniChain.feature.canteen.payload.request;

import com.agiles.UniChain.generic.payload.request.IDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequestDto implements IDto {

    private String name;
    private String description;
    private String location;
    private String contactNumber;
    private String contactNumber2;
    private String email;
    private String isOpen;
    MultipartFile image;

}
