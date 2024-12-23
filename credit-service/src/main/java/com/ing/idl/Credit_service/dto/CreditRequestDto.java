package com.ing.idl.Credit_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditRequestDto {
    private Long clientId;
    private Double amount;
    private Long durationInMonths;
}
