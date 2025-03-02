//package com.agiles.UniChain.feature.canteen.controller;
//
//import com.agiles.UniChain.feature.canteen.entity.FoodOrder;
//import com.agiles.UniChain.feature.canteen.payload.request.FoodOrderRequestDto;
//import com.agiles.UniChain.generic.controller.AbstractController;
//import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
//import com.agiles.UniChain.generic.payload.response.PageData;
//import com.agiles.UniChain.generic.service.IService;
//import org.springframework.data.domain.Pageable;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@RequestMapping("FoodOrder")
//public class FoodOrderController extends AbstractController<FoodOrder, FoodOrderRequestDto, GenericSearchDto> {
//    public FoodOrderController(IService<FoodOrder, FoodOrderRequestDto, GenericSearchDto> service) {
//        super(service);
//    }
//
//    @GetMapping("get")
//    public PageData getAll(Boolean isActive, Pageable pageable) {
//        return null;
//    }
//}
