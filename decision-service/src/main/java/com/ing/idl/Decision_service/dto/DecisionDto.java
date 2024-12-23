package com.ing.idl.Decision_service.dto;

import com.ing.idl.Decision_service.entity.StatusDecisionEnum;
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
