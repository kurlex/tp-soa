package com.ing.soaproject.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("cin")
    private Long cin;

    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("monthlyPayment")
    private Double monthlyPayment;
    @JsonProperty("scaleId")
    private Long scaleId;
    @JsonProperty("interest")
    private Double interest;
    @JsonProperty("scoreDto")
    private ScoreDto scoreDto;

    @JsonProperty("durationInMonths")
    private Integer durationInMonths;
    public CreditDto(Long cin, Double amount, Integer durationInMonths) {
        this.cin = cin;
        this.amount = amount;
        this.durationInMonths = durationInMonths;
    }

}
