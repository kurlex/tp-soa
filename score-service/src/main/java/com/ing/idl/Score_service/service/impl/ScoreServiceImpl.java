package com.ing.idl.Score_service.service.impl;

import com.ing.idl.Score_service.dto.ContractEnum;
import com.ing.idl.Score_service.dto.EvaluationEnum;
import com.ing.idl.Score_service.dto.ScoreDto;
import com.ing.idl.Score_service.entity.ScoreEntity;
import com.ing.idl.Score_service.mapper.impl.ScoreMapper;
import com.ing.idl.Score_service.repository.ScoreRepository;
import com.ing.idl.Score_service.service.ScoreService;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;
    private final ScoreMapper scoreMapper;

    public ScoreServiceImpl(ScoreRepository scoreRepository, ScoreMapper scoreMapper) {
        this.scoreRepository = scoreRepository;
        this.scoreMapper = scoreMapper;
    }

    @Override
    public int computeScore(double salary, ContractEnum contractType, double monthlyPayment) {
        int score = 0;

        if (salary > 2000) {
            score += 20;
        } else if (salary > 1000 && salary < 2000) {
            score += 10;
        }

        if (ContractEnum.CDI == contractType) {
            score += 30;
        }

        if (monthlyPayment / salary < 0.45) {
            score += 50;
        }

        return score;
    }

    public ScoreDto addScore(ScoreEntity scoreEntity){
        scoreEntity = scoreRepository.save(scoreEntity);
        ScoreDto scoreDto = scoreMapper.toDto(scoreEntity);
        scoreDto.setEvaluation(scoreDto.getScore() < 50 ? EvaluationEnum.Red : EvaluationEnum.Green);
        return scoreDto;
    }
}
