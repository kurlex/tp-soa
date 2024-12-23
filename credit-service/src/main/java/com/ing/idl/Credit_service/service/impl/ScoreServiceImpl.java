package com.ing.idl.Credit_service.service.impl;

import com.ing.idl.Credit_service.dto.ScaleDto;
import com.ing.idl.Credit_service.entity.ScaleEntity;
import com.ing.idl.Credit_service.mapper.impl.ScaleMapper;
import com.ing.idl.Credit_service.service.ScaleService;
import com.ing.idl.Credit_service.repository.ScaleRepository;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@Service
public class ScaleServiceImpl implements ScaleService {

    private final ScaleRepository scaleRepository;
    private final ScaleMapper scaleMapper;

    public ScaleServiceImpl(ScaleRepository scaleRepository, ScaleMapper scaleMapper) {
        this.scaleRepository = scaleRepository;
        this.scaleMapper = scaleMapper;
    }

    @Override
    public ScaleEntity getScale(Double amount, long durationInMonths) {
        List<ScaleEntity> scaleEntities = this.scaleRepository.findAll();

        List<ScaleEntity> validScales = scaleEntities.stream()
                .filter(scale -> durationInMonths >= scale.getMinimumDurationInMonths() &&
                        durationInMonths <= scale.getMaximumDurationInMonths() &&
                        amount >= scale.getMinimumAmount() &&
                        amount <= scale.getMaximumAmount())
                .toList();

        if (!validScales.isEmpty()) {
            return validScales.stream()
                    .min(Comparator.comparing(ScaleEntity::getInterestRate))
                    .orElseThrow(() -> new RuntimeException("No scale found"));
        }

        return null;
    }

    @Override
    public ScaleDto addScale(ScaleDto scaleDto){
        ScaleEntity scaleEntity = this.scaleMapper.toEntity(scaleDto);
        scaleEntity = scaleRepository.save(scaleEntity);
        return scaleMapper.toDto(scaleEntity);
    }
}
