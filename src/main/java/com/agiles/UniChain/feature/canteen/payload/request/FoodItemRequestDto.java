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
public class FoodItemRequestDto implements IDto {

    private String name;
    private double price;
    private String shortDescription;
    private String ingredients;
    private String preparationMethod;
    private String quantity;
    private Boolean available;
    MultipartFile image;
    private Long restaurantId;


}
