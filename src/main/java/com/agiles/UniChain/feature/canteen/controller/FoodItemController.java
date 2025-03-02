package com.agiles.UniChain.feature.canteen.controller;

import com.agiles.UniChain.feature.canteen.entity.FoodItem;
import com.agiles.UniChain.feature.canteen.payload.request.FoodItemRequestDto;
import com.agiles.UniChain.feature.canteen.service.FoodItemService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.PageData;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("FoodItem")
public class FoodItemController extends AbstractController<FoodItem, FoodItemRequestDto, GenericSearchDto> {

    public FoodItemController(FoodItemService service) {
        super(service);
    }

}
