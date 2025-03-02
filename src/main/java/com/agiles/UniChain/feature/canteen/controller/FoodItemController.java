package com.agiles.UniChain.feature.canteen.controller;

import com.agiles.UniChain.feature.canteen.entity.FoodItem;
import com.agiles.UniChain.feature.canteen.payload.request.FoodItemRequestDto;
import com.agiles.UniChain.feature.canteen.service.FoodItemService;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.PageData;
import com.agiles.UniChain.generic.service.IService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("FoodItem")
public class FoodItemController extends AbstractController<FoodItem, FoodItemRequestDto, GenericSearchDto> {

    @Autowired
    FoodItemService foodItemService;
    public FoodItemController(FoodItemService service) {
        super(service);
    }

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Override
    public ResponseEntity<String> create(@ModelAttribute FoodItemRequestDto dto) throws IOException {
        foodItemService.create(dto);
        return ResponseEntity.ok("Food Item Created Successfully");
    }
}
