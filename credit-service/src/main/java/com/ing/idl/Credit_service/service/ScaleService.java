package com.ing.idl.Credit_service.service;

import com.ing.idl.Credit_service.dto.ScaleDto;
import com.ing.idl.Credit_service.entity.ScaleEntity;

public interface ScaleService {
    ScaleEntity getScale(Double amount, long durationInMonths);
    ScaleDto addScale(ScaleDto scaleDto);
}
