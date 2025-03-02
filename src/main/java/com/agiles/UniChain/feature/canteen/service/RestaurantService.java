package com.agiles.UniChain.feature.canteen.service;

import com.agiles.UniChain.feature.canteen.entity.Restaurant;
import com.agiles.UniChain.feature.canteen.payload.request.RestaurantRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface RestaurantService extends
        IService<Restaurant, RestaurantRequestDto, GenericSearchDto> {
}
