package com.ing.orchestrator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreRequestDto {
    @JsonProperty("cin")
    private Long CIN;
    @JsonProperty("creditId")
    private Long creditId;
    @JsonProperty("monthlyPayment")
    private Double monthlyPayment;

    public ScoreRequestDto(Long CIN, Long creditId, Double monthlyPayment) {
        this.CIN = CIN;
        this.creditId = creditId;
        this.monthlyPayment = monthlyPayment;
    }
}