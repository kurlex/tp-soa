package com.ing.idl.Score_service.controller;

import com.ing.idl.Score_service.dto.*;
import com.ing.idl.Score_service.entity.ScoreEntity;
import com.ing.idl.Score_service.service.BCTService;
import com.ing.idl.Score_service.service.ClientService;
import com.ing.idl.Score_service.service.DecisionService;
import com.ing.idl.Score_service.service.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    private final ClientService clientService;
    private final ScoreService scoreService;
    private final DecisionService decisionService;
    private final BCTService bctService;

    public ScoreController(ClientService clientService, ScoreService scoreService, DecisionService decisionService, BCTService bctService) {
        this.clientService = clientService;
        this.scoreService = scoreService;
        this.decisionService = decisionService;
        this.bctService = bctService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ScoreDto>> createScore(@RequestBody ScoreRequestDto scoreRequestDto) {
        ClientDto client = clientService.getClientById(scoreRequestDto.getCIN());

        int score = bctService.checkClient(new BlacklistRequestDto(scoreRequestDto.getCIN()))
                ? 0
                : scoreService.computeScore(client.getSalary(), client.getContract(), scoreRequestDto.getMonthlyPayment());

        ScoreEntity scoreEntity = new ScoreEntity(scoreRequestDto.getCreditId(), score);
        ScoreDto scoreDto = scoreService.addScore(scoreEntity);
        DecisionRequestDto decisionRequestDto = new DecisionRequestDto(
                scoreRequestDto.getCreditId(),
                scoreDto.getEvaluation()
        );
        decisionService.addDecision(decisionRequestDto);
        ApiResponse<ScoreDto> response = new ApiResponse<>(scoreDto, "Score created successfully.", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
