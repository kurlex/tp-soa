package com.ing.idl.Credit_service.service;

import com.ing.idl.Credit_service.dto.CreditDto;
import com.ing.idl.Credit_service.entity.CreditEntity;

import java.util.List;

public interface CreditService {
    CreditDto addCredit(CreditEntity creditEntity);
    List<CreditDto> getCreditByClientId(Long clientId);
}
