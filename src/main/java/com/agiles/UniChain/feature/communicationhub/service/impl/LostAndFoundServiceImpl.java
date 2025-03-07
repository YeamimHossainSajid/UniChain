package com.agiles.UniChain.feature.communicationhub.service.impl;

import com.agiles.UniChain.config.image.service.CloudneryImageService;
import com.agiles.UniChain.feature.communicationhub.entity.LostAndFound;
import com.agiles.UniChain.feature.communicationhub.payload.request.LostAndFoundRequest;
import com.agiles.UniChain.feature.communicationhub.payload.response.LostAndFoundResponse;
import com.agiles.UniChain.feature.communicationhub.service.LostAndFoundService;
import com.agiles.UniChain.feature.student.entity.Student;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
import com.agiles.UniChain.generic.repository.AbstractRepository;
import com.agiles.UniChain.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
@Service
public class LostAndFoundServiceImpl extends AbstractService<LostAndFound, LostAndFoundRequest, GenericSearchDto>implements LostAndFoundService {

    @Autowired
    CloudneryImageService cloudneryImageService;

    public LostAndFoundServiceImpl(AbstractRepository<LostAndFound> repository) {
        super(repository);
    }

    @Override
    protected LostAndFoundResponse convertToResponseDto(LostAndFound lostAndFound) {

        LostAndFoundResponse response = new LostAndFoundResponse();

        response.setId(lostAndFound.getId());
        response.setName(lostAndFound.getName());
        response.setDescription(lostAndFound.getDescription());
        response.setContacts(lostAndFound.getContacts());
        response.setTime(lostAndFound.getTime());
        response.setPicture(lostAndFound.getPicture());

        return response;
    }

    @Override
    protected LostAndFound convertToEntity(LostAndFoundRequest lostAndFoundRequest) throws IOException {
        return updateEntity(lostAndFoundRequest, new LostAndFound());
    }

    @Override
    protected LostAndFound updateEntity(LostAndFoundRequest request, LostAndFound entity) throws IOException {
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setContacts(request.getContacts());
        entity.setTime(request.getTime());
//        entity.setPicture(request.getPicture());


        return null;
    }

    @Override
    protected Specification<LostAndFound> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }

    public void createV2(LostAndFoundRequest request, MultipartFile image) throws IOException {
        LostAndFound entity = new LostAndFound();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setContacts(request.getContacts());
        entity.setTime(request.getTime());
        String profileImageUrl = "https://res.cloudinary.com/dxmwiwy6g/image/upload/v1740298839/jhp0yhawmfwffy195dn8.jpg";
        if (image != null && !image.isEmpty()) {
            Map<String, Object> uploadResult = cloudneryImageService.upload(image);
            profileImageUrl = (String) uploadResult.get("secure_url");
        }
        entity.setPicture(profileImageUrl);
    }
}
