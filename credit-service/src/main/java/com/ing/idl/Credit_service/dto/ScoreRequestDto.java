package com.ing.idl.Credit_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreRequestDto {
    private Long CIN;
    private Long creditId;
    private Double monthlyPayment;
}