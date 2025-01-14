package com.ing.idl.Decision_service.service.impl;

import com.ing.idl.Decision_service.dto.DecisionDto;
import com.ing.idl.Decision_service.entity.DecisionEntity;
import com.ing.idl.Decision_service.mapper.impl.DecisionMapper;
import com.ing.idl.Decision_service.mapper.impl.DecisionMapper;
import com.ing.idl.Decision_service.repository.DecisionRepository;
import com.ing.idl.Decision_service.service.DecisionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DecisionServiceImpl implements DecisionService {

    private final DecisionRepository decisionRepository;
    private final DecisionMapper decisionMapper;

    public DecisionServiceImpl(DecisionRepository decisionRepository, DecisionMapper decisionMapper) {
        this.decisionRepository = decisionRepository;
        this.decisionMapper = decisionMapper;
    }

    @Override
    public DecisionDto addDecision(DecisionEntity decisionEntity) {
        DecisionEntity decision = decisionRepository.save(decisionEntity);
        return decisionMapper.toDto(decision);
    }

}
