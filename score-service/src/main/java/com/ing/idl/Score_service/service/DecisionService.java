package com.ing.idl.Score_service.service;

import com.ing.idl.Score_service.dto.ContractEnum;
import com.ing.idl.Score_service.dto.DecisionDto;
import com.ing.idl.Score_service.dto.DecisionRequestDto;
import com.ing.idl.Score_service.dto.ScoreDto;
import com.ing.idl.Score_service.entity.ScoreEntity;

public interface DecisionService {
    DecisionDto addDecision(DecisionRequestDto decisionRequestDto);
}
