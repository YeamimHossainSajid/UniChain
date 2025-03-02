package com.agiles.UniChain.feature.canteen.service;

import com.agiles.UniChain.feature.canteen.entity.FoodItem;
import com.agiles.UniChain.feature.canteen.payload.request.FoodItemRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.request.IDto;
import com.agiles.UniChain.generic.service.IService;

public interface FoodItemService extends
        IService<FoodItem, FoodItemRequestDto, GenericSearchDto>, IDto {

}
