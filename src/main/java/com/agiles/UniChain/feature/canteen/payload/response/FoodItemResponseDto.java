package com.agiles.UniChain.feature.canteen.payload.response;

import com.agiles.UniChain.generic.payload.request.SDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemResponseDto extends BaseResponseDto {

    private Long id;
    private String name;
    private double price;
    private String shortDescription;
    private String ingredients;
    private String preparationMethod;
    private String quantity;
    private Boolean available;
    private RestaurantResponseDto restaurant;

}
