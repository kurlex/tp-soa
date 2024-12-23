package com.ing.idl.Credit_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credit")
public class CreditEntity {
    public CreditEntity(Long clientId, Long scaleId, Double amount, Double interest, Long durationInMonths) {
        this.clientId = clientId;
        this.scaleId = scaleId;
        this.amount = amount;
        this.interest = interest;
        this.durationInMonths = durationInMonths;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private Long scaleId;
    private Double amount;
    private Double interest;
    private Long durationInMonths;
}
