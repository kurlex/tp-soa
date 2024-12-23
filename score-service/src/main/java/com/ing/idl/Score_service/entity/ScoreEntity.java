package com.ing.idl.Score_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "score")
public class ScoreEntity {
    public ScoreEntity(Long creditId, int score) {
        this.creditId = creditId;
        this.score = score;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long creditId;
    private int score;
}
