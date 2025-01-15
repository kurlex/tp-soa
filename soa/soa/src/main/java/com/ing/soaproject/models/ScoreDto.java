package com.ing.soaproject.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("creditId")
    private Long creditId;
    @JsonProperty("score")
    private int score;

}