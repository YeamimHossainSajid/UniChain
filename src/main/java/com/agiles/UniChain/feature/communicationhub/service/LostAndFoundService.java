package com.agiles.UniChain.feature.communicationhub.service;

import com.agiles.UniChain.feature.communicationhub.entity.LostAndFound;
import com.agiles.UniChain.feature.communicationhub.payload.request.LostAndFoundRequest;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.AbstractService;
import com.agiles.UniChain.generic.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface LostAndFoundService extends IService<LostAndFound, LostAndFoundRequest, GenericSearchDto> {
    public void createV2(LostAndFoundRequest request, MultipartFile image) throws IOException;
}
