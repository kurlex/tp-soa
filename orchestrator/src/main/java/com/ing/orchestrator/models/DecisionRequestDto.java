package com.ing.orchestrator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DecisionRequestDto {
    @JsonProperty("creditId")
    private Long CreditId;
    @JsonProperty("evaluation")
    private String evaluation;

    public DecisionRequestDto(Long creditId, String evaluation) {
        this.CreditId = creditId;
        this.evaluation = evaluation;
    }
}
