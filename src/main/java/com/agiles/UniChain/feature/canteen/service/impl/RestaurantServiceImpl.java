package com.agiles.UniChain.feature.canteen.service.impl;

import com.agiles.UniChain.feature.canteen.entity.Restaurant;
import com.agiles.UniChain.feature.canteen.payload.request.RestaurantRequestDto;
import com.agiles.UniChain.feature.canteen.payload.response.FoodItemResponseDto;
import com.agiles.UniChain.feature.canteen.payload.response.RestaurantResponseDto;
import com.agiles.UniChain.feature.canteen.service.RestaurantService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl extends AbstractService<Restaurant, RestaurantRequestDto, GenericSearchDto> implements RestaurantService {

    public RestaurantServiceImpl(AbstractRepository<Restaurant> repository) {
        super(repository);
    }

    @Override
    protected RestaurantResponseDto convertToResponseDto(Restaurant restaurant) {
        RestaurantResponseDto responseDto = new RestaurantResponseDto();
        responseDto.setId(restaurant.getId());
        responseDto.setName(restaurant.getName());
        responseDto.setDescription(restaurant.getDescription());
        responseDto.setLocation(restaurant.getLocation());
        responseDto.setContactNumber(restaurant.getContactNumber());
        responseDto.setContactNumber2(restaurant.getContactNumber2());
        responseDto.setEmail(restaurant.getEmail());
        responseDto.setIsOpen(restaurant.getIsOpen());

        // Null check for foodItems
        List<FoodItemResponseDto> foodItems = Optional.ofNullable(restaurant.getFoodItems())
                .orElse(Collections.emptyList())  // If null, return empty list
                .stream().map(foodItem -> {
                    FoodItemResponseDto dto = new FoodItemResponseDto();
                    dto.setId(foodItem.getId());
                    dto.setName(foodItem.getName());
                    dto.setPrice(foodItem.getPrice());
                    dto.setShortDescription(foodItem.getShortDescription());
                    dto.setIngredients(foodItem.getIngredients());
                    dto.setPreparationMethod(foodItem.getPreparationMethod());
                    dto.setQuantity(foodItem.getQuantity());
                    dto.setAvailable(foodItem.getAvailable());
                    return dto;
                }).collect(Collectors.toList());

        responseDto.setFoodItems(foodItems);
        return responseDto;
    }

    @Override
    protected Restaurant convertToEntity(RestaurantRequestDto restaurantRequestDto) {
        return updateEntity(restaurantRequestDto, new Restaurant());
    }

    @Override
    protected Restaurant updateEntity(RestaurantRequestDto restaurantRequestDto, Restaurant entity) {
        entity.setName(restaurantRequestDto.getName());
        entity.setDescription(restaurantRequestDto.getDescription());
        entity.setLocation(restaurantRequestDto.getLocation());
        entity.setContactNumber(restaurantRequestDto.getContactNumber());
        entity.setContactNumber2(restaurantRequestDto.getContactNumber2());
        entity.setEmail(restaurantRequestDto.getEmail());
        entity.setIsOpen(restaurantRequestDto.getIsOpen());

        return entity;
    }

    @Override
    protected Specification<Restaurant> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}

