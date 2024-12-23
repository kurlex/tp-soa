package com.ing.idl.Credit_service.service;

import com.ing.idl.Credit_service.dto.ScaleDto;
import com.ing.idl.Credit_service.dto.ScoreDto;
import com.ing.idl.Credit_service.dto.ScoreRequestDto;
import com.ing.idl.Credit_service.entity.ScaleEntity;

public interface ScoreService {
    ScoreDto getScore(ScoreRequestDto scoreRequestDto);
}
