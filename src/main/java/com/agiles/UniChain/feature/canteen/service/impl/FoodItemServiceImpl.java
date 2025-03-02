package com.agiles.UniChain.feature.canteen.service.impl;

import com.agiles.UniChain.feature.canteen.entity.FoodItem;
import com.agiles.UniChain.feature.canteen.payload.request.FoodItemRequestDto;
import com.agiles.UniChain.feature.canteen.service.FoodItemService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FoodItemServiceImpl extends AbstractService<FoodItem, FoodItemRequestDto, GenericSearchDto> implements FoodItemService {

    public FoodItemServiceImpl(AbstractRepository<FoodItem> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(FoodItem foodItem) {
        return null;
    }

    @Override
    protected FoodItem convertToEntity(FoodItemRequestDto foodItemRequestDto) {
        return null;
    }

    @Override
    protected FoodItem updateEntity(FoodItemRequestDto foodItemRequestDto, FoodItem entity) {
        return null;
    }

    @Override
    protected Specification<FoodItem> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
