package com.agiles.UniChain.feature.canteen.service.impl;

import com.agiles.UniChain.feature.canteen.entity.FoodItem;
import com.agiles.UniChain.feature.canteen.payload.request.FoodItemRequestDto;
import com.agiles.UniChain.feature.canteen.payload.response.FoodItemResponseDto;
import com.agiles.UniChain.feature.canteen.service.FoodItemService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FoodItemServiceImpl extends AbstractService<FoodItem, FoodItemRequestDto, GenericSearchDto> implements FoodItemService {

    public FoodItemServiceImpl(AbstractRepository<FoodItem> foodItemRepository) {
        super(foodItemRepository);
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

        return  responseDto;
    }

    @Override
    protected FoodItem convertToEntity(FoodItemRequestDto foodItemRequestDto) {
        // Convert the request DTO to FoodItem entity
        return updateEntity(foodItemRequestDto, new FoodItem());
    }

    @Override
    protected FoodItem updateEntity(FoodItemRequestDto foodItemRequestDto, FoodItem entity) {
        // Update the fields of the existing entity with data from the request DTO
        entity.setName(foodItemRequestDto.getName());
        entity.setPrice(foodItemRequestDto.getPrice());
        entity.setShortDescription(foodItemRequestDto.getShortDescription());
        entity.setIngredients(foodItemRequestDto.getIngredients());
        entity.setPreparationMethod(foodItemRequestDto.getPreparationMethod());
        entity.setQuantity(foodItemRequestDto.getQuantity());
        entity.setAvailable(foodItemRequestDto.getAvailable());

        return entity;
    }

    @Override
    protected Specification<FoodItem> buildSpecification(GenericSearchDto searchDto) {

        return null;
    }
}
