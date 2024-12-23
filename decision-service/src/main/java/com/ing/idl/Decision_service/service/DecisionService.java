package com.ing.idl.Decision_service.service;

import com.ing.idl.Decision_service.dto.DecisionDto;
import com.ing.idl.Decision_service.entity.DecisionEntity;

public interface DecisionService {
    DecisionDto addDecision(DecisionEntity decisionEntity);
}
