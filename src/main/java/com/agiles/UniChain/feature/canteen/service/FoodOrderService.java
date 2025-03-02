package com.agiles.UniChain.feature.canteen.service;

import com.agiles.UniChain.feature.canteen.entity.FoodOrder;
import com.agiles.UniChain.feature.canteen.payload.request.FoodOrderRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface FoodOrderService extends
        IService<FoodOrder, FoodOrderRequestDto, GenericSearchDto> {
}
