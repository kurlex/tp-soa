package com.ing.idl.Credit_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScaleDto {
    private Long id;
    private Double interestRate;
    private Long minimumDurationInMonths;
    private Long maximumDurationInMonths;
    private Double minimumAmount;
    private Double maximumAmount;
}
