package com.ing.idl.Score_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecisionRequestDto {
    private Long CreditId;
    private EvaluationEnum evaluation;
}