package com.ing.idl.Score_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecisionDto {
    private Long id;
    private Date created_at;
    private Long Credit_id;
    private StatusDecisionEnum statusDecision;
}
