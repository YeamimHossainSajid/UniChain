package com.agiles.UniChain.feature.canteen.service.impl;

import com.agiles.UniChain.feature.canteen.entity.FoodItem;
import com.agiles.UniChain.feature.canteen.entity.Restaurant;
import com.agiles.UniChain.feature.canteen.payload.request.FoodItemRequestDto;
import com.agiles.UniChain.feature.canteen.payload.response.FoodItemResponseDto;
import com.agiles.UniChain.feature.canteen.payload.response.RestaurantResponseDto;
import com.agiles.UniChain.feature.canteen.repository.RestaurantRepository;
import com.agiles.UniChain.feature.canteen.service.FoodItemService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FoodItemServiceImpl extends AbstractService<FoodItem, FoodItemRequestDto, GenericSearchDto> implements FoodItemService {

    private final RestaurantRepository restaurantRepository;

    public FoodItemServiceImpl(AbstractRepository<FoodItem> foodItemRepository, RestaurantRepository restaurantRepository) {
        super(foodItemRepository);
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    protected FoodItemResponseDto convertToResponseDto(FoodItem foodItem) {
        FoodItemResponseDto responseDto = new FoodItemResponseDto();
        responseDto.setName(foodItem.getName());
        responseDto.setPrice(foodItem.getPrice());
        responseDto.setShortDescription(foodItem.getShortDescription());
        responseDto.setIngredients(foodItem.getIngredients());
        responseDto.setPreparationMethod(foodItem.getPreparationMethod());
        responseDto.setQuantity(foodItem.getQuantity());
        responseDto.setAvailable(foodItem.getAvailable());

        if (foodItem.getRestaurant() != null) {
            RestaurantResponseDto restaurantDto = new RestaurantResponseDto();
            restaurantDto.setId(foodItem.getRestaurant().getId());
            restaurantDto.setName(foodItem.getRestaurant().getName());
            restaurantDto.setDescription(foodItem.getRestaurant().getDescription());
            restaurantDto.setLocation(foodItem.getRestaurant().getLocation());
            restaurantDto.setContactNumber(foodItem.getRestaurant().getContactNumber());
            restaurantDto.setContactNumber2(foodItem.getRestaurant().getContactNumber2());
            restaurantDto.setEmail(foodItem.getRestaurant().getEmail());
            restaurantDto.setIsOpen(foodItem.getRestaurant().getIsOpen());

            responseDto.setRestaurant(restaurantDto);
        }

        return responseDto;
    }



    @Override
    protected FoodItem convertToEntity(FoodItemRequestDto foodItemRequestDto) {
        return updateEntity(foodItemRequestDto, new FoodItem());
    }

    @Override
    protected FoodItem updateEntity(FoodItemRequestDto foodItemRequestDto, FoodItem entity) {
        entity.setName(foodItemRequestDto.getName());
        entity.setPrice(foodItemRequestDto.getPrice());
        entity.setShortDescription(foodItemRequestDto.getShortDescription());
        entity.setIngredients(foodItemRequestDto.getIngredients());
        entity.setPreparationMethod(foodItemRequestDto.getPreparationMethod());
        entity.setQuantity(foodItemRequestDto.getQuantity());
        entity.setAvailable(foodItemRequestDto.getAvailable());
        if (foodItemRequestDto.getRestaurantId() != null) {
            Restaurant restaurant = restaurantRepository.findById(foodItemRequestDto.getRestaurantId())
                    .orElseThrow(() -> new RuntimeException("Restaurant not found with ID: " + foodItemRequestDto.getRestaurantId()));
            entity.setRestaurant(restaurant);
        }

        return entity;
    }

    @Override
    protected Specification<FoodItem> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}

