package com.ing.orchestrator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("creditId")
    private Long creditId;
    @JsonProperty("score")
    private int score;
    @JsonProperty("evaluation")
    private String evaluation;

    public String getEvaluation() {
        return evaluation;
    }

    @Override
    public String toString() {
        return "ScoreDto{" +
                "id=" + id +
                ", creditId=" + creditId +
                ", score=" + score +
                ", evaluation='" + evaluation + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }


    public int getScore() {
        return score;
    }
}