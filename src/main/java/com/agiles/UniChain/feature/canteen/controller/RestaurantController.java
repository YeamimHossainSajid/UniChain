package com.agiles.UniChain.feature.canteen.controller;

import com.agiles.UniChain.feature.canteen.entity.Restaurant;
import com.agiles.UniChain.feature.canteen.payload.request.RestaurantRequestDto;
import com.agiles.UniChain.feature.canteen.service.RestaurantService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.PageData;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Restaurant")
public class RestaurantController extends AbstractController<Restaurant, RestaurantRequestDto, GenericSearchDto> {

    public RestaurantController(RestaurantService service) {
        super(service);
    }

}
