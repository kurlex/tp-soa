package com.ing.idl.Credit_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditDto {
    private Long id;

    private Long scaleId;
    private Double amount;
    private Double interest;
    private Long durationInMonths;
    private Double monthlyPayment;
    private ScoreDto scoreDto;

}
