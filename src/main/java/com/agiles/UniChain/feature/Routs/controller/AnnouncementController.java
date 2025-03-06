package com.agiles.UniChain.feature.Routs.controller;

import com.agiles.UniChain.feature.Routs.entity.Announcement;
import com.agiles.UniChain.feature.Routs.payload.request.AnnouncementRequestDTO;
import com.agiles.UniChain.generic.controller.AbstractController;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("announcement")
public class AnnouncementController extends AbstractController <Announcement, AnnouncementRequestDTO, GenericSearchDto> {
    public AnnouncementController(IService<Announcement, AnnouncementRequestDTO, GenericSearchDto> service) {
        super(service);
    }
}
