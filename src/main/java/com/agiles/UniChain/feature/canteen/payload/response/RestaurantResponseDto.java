package com.agiles.UniChain.feature.canteen.payload.response;

import com.agiles.UniChain.auth.dto.response.CustomUserResponseDTO;
import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponseDto extends BaseResponseDto {

    private Long id;
    private String name;
    private String description;
    private String location;
    private String contactNumber;
    private String contactNumber2;
    private String email;
    private String isOpen;
    private String imageUrl;
//    private CustomUserResponseDTO user;

    private List<FoodItemResponseDto> foodItems;
}
