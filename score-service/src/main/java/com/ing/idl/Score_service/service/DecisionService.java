package com.ing.idl.Score_service.service;

import com.ing.idl.Score_service.dto.ClientDto;
import com.ing.idl.Score_service.dto.ContractEnum;
import com.ing.idl.Score_service.dto.ScoreDto;
import com.ing.idl.Score_service.entity.ScoreEntity;

public interface ScoreService {
    int computeScore(double salary, ContractEnum contract, double monthlyPayment);
    ScoreDto addScore(ScoreEntity scoreEntity);
}
