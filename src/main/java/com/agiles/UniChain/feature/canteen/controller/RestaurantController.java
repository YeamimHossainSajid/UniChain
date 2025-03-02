package com.agiles.UniChain.feature.canteen.controller;

import com.agiles.UniChain.feature.canteen.entity.Restaurant;
import com.agiles.UniChain.feature.canteen.payload.request.FoodItemRequestDto;
import com.agiles.UniChain.feature.canteen.payload.request.RestaurantRequestDto;
import com.agiles.UniChain.feature.canteen.service.RestaurantService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.PageData;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("Restaurant")
public class RestaurantController extends AbstractController<Restaurant, RestaurantRequestDto, GenericSearchDto> {

    @Autowired
    RestaurantService restaurantService;
    public RestaurantController(RestaurantService service) {
        super(service);
    }

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Override
    public ResponseEntity<String> create(@ModelAttribute RestaurantRequestDto dto) throws IOException {
      restaurantService.create(dto);
        return ResponseEntity.ok("Food Item Created Successfully");
    }

}
