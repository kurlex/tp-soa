package com.ing.idl.Credit_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scale")
public class ScaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double interestRate;
    private Long minimumDurationInMonths;
    private Long maximumDurationInMonths;
    private Double minimumAmount;
    private Double maximumAmount;
}