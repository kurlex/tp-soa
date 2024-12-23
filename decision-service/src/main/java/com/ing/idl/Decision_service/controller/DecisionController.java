package com.ing.idl.Decision_service.controller;

import com.ing.idl.Decision_service.dto.ApiResponse;
import com.ing.idl.Decision_service.dto.DecisionDto;
import com.ing.idl.Decision_service.dto.DecisionRequestDto;
import com.ing.idl.Decision_service.entity.DecisionEntity;
import com.ing.idl.Decision_service.service.DecisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/decisions")
public class DecisionController {
    private final DecisionService decisionService;

    public DecisionController(DecisionService decisionService) {
        this.decisionService = decisionService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DecisionDto>> createDecision(@RequestBody DecisionRequestDto decisionRequestDto) {
        DecisionEntity decisionEntity = new DecisionEntity(decisionRequestDto.getCreditId(), decisionRequestDto.getEvaluation());
        DecisionDto decisionDto = decisionService.addDecision(decisionEntity);
        ApiResponse<DecisionDto> response = new ApiResponse<>(decisionDto, "Decision created successfully.", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
