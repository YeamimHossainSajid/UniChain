package com.agiles.UniChain.feature.Routs.service;

import com.agiles.UniChain.feature.Routs.entity.Announcement;
import com.agiles.UniChain.feature.Routs.payload.request.AnnouncementRequestDTO;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.IService;

public interface AnnouncementService extends IService<Announcement, AnnouncementRequestDTO, GenericSearchDto> {
}
