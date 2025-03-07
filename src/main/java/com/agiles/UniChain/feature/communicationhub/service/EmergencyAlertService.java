package com.agiles.UniChain.feature.communicationhub.service;

import com.agiles.UniChain.feature.communicationhub.entity.EmergencyAlert;
import com.agiles.UniChain.feature.communicationhub.payload.request.EmergencyAlertRequestDto;
import com.agiles.UniChain.generic.payload.request.GenericSearchDto;
import com.agiles.UniChain.generic.service.AbstractService;
import com.agiles.UniChain.generic.service.IService;

public interface EmergencyAlertService extends IService<EmergencyAlert, EmergencyAlertRequestDto, GenericSearchDto> {
}
