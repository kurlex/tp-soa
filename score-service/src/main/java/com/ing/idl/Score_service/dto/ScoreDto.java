package com.ing.idl.Score_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDto {
    private Long id;
    private Long creditId;
    private int score;
    private EvaluationEnum evaluation;
}
