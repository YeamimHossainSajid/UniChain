package com.agiles.UniChain.feature.canteen.service.impl;

import com.agiles.UniChain.feature.canteen.entity.FoodOrder;
import com.agiles.UniChain.feature.canteen.payload.request.FoodOrderRequestDto;

import com.agiles.UniChain.feature.canteen.service.FoodOrderService;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;

import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderServiceImpl extends AbstractService<FoodOrder, FoodOrderRequestDto, GenericSearchDto> implements FoodOrderService {

    public FoodOrderServiceImpl(AbstractRepository<FoodOrder> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(FoodOrder foodOrder) {
        return null;
    }

    @Override
    protected FoodOrder convertToEntity(FoodOrderRequestDto foodOrderRequestDto) {
        return null;
    }

    @Override
    protected FoodOrder updateEntity(FoodOrderRequestDto foodOrderRequestDto, FoodOrder entity) {
        return null;
    }

    @Override
    protected Specification<FoodOrder> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }


}
