package com.ing.orchestrator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("cin")
    private Long cin;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("durationInMonths")
    private Integer durationInMonths;

    // Constructors, Getters, and Setters
    public CreditDto() {}

    public CreditDto(Long cin, Double amount, Integer durationInMonths) {
        this.cin = cin;
        this.amount = amount;
        this.durationInMonths = durationInMonths;
    }

    public  Long getId() {return this.id;}

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(Integer durationInMonths) {
        this.durationInMonths = durationInMonths;
    }
}
