package com.agiles.UniChain.feature.canteen.service.impl;

import com.agiles.UniChain.feature.canteen.entity.FoodItem;
import com.agiles.UniChain.feature.canteen.entity.Restaurant;
import com.agiles.UniChain.feature.canteen.payload.request.RestaurantRequestDto;
import com.agiles.UniChain.feature.canteen.payload.response.RestaurantResponseDto;
import com.agiles.UniChain.feature.canteen.service.RestaurantService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class RestaurantServiceImpl extends AbstractService<Restaurant, RestaurantRequestDto, GenericSearchDto> implements RestaurantService {

    public RestaurantServiceImpl(AbstractRepository<Restaurant> repository) {
        super(repository);
    }

    @Override
    protected RestaurantResponseDto convertToResponseDto(Restaurant restaurant) {

        RestaurantResponseDto responseDto = new RestaurantResponseDto();
        responseDto.setName(restaurant.getName());
        responseDto.setDescription(restaurant.getDescription());
        responseDto.setLocation(restaurant.getLocation());
        responseDto.setContactNumber(restaurant.getContactNumber());
        responseDto.setContactNumber2(restaurant.getContactNumber2());
        responseDto.setEmail(restaurant.getEmail());
        responseDto.setIsOpen(restaurant.getIsOpen());


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

