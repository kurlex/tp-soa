package com.ing.orchestrator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class DecisionDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("created_at")
    private String created_at;
    @JsonProperty("credit_id")
    private Long Credit_id;
    @JsonProperty("statusDecision")
    private String statusDecision;

    public String getStatusDecision() {
        return statusDecision;
    }

    public Long getId() {
        return id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public Long getCredit_id() {
        return Credit_id;
    }

    @Override
    public String toString() {
        return "DecisionDto{" +
                "id=" + id +
                ", created_at='" + created_at + '\'' +
                ", Credit_id=" + Credit_id +
                ", statusDecision='" + statusDecision + '\'' +
                '}';
    }
}
