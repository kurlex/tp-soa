package com.ing.orchestrator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScaleDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("interestRate")
    private Double interestRate;
    @JsonProperty("minimumDurationInMonths")
    private Long minimumDurationInMonths;
    @JsonProperty("maximumDurationInMonths")
    private Long maximumDurationInMonths;
    @JsonProperty("minimumAmount")
    private Double minimumAmount;
    @JsonProperty("maximumAmount")
    private Double maximumAmount;

    public ScaleDto() {}

    public ScaleDto(Double interestRate, Long minimumDurationInMonths, Long maximumDurationInMonths, Double minimumAmount, Double maximumAmount) {
        this.interestRate = interestRate;
        this.minimumDurationInMonths = minimumDurationInMonths;
        this.maximumDurationInMonths = maximumDurationInMonths;
        this.minimumAmount = minimumAmount;
        this.maximumAmount = maximumAmount;
    }

    public Long getId() {
        return id;
    }
}
