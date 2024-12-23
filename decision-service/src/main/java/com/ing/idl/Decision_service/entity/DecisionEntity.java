package com.ing.idl.Decision_service.entity;

import com.ing.idl.Decision_service.dto.EvaluationEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "decision")
public class DecisionEntity {
    public DecisionEntity(Long Credit_id, EvaluationEnum evaluation) {
        this.Credit_id = Credit_id;
        this.statusDecision = evaluation == EvaluationEnum.Red ? StatusDecisionEnum.REJECTED : StatusDecisionEnum.ACCEPTED;
        this.created_at = new Date();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date created_at;
    @Column(name = "Credit_id", nullable = false, unique = true)
    private Long Credit_id;
    private StatusDecisionEnum statusDecision;
}
