package com.ing.idl.Credit_service.controller;

import com.ing.idl.Credit_service.dto.ApiResponse;
import com.ing.idl.Credit_service.dto.CreditDto;
import com.ing.idl.Credit_service.dto.CreditRequestDto;
import com.ing.idl.Credit_service.dto.ScoreRequestDto;
import com.ing.idl.Credit_service.entity.CreditEntity;
import com.ing.idl.Credit_service.entity.ScaleEntity;
import com.ing.idl.Credit_service.service.CreditService;
import com.ing.idl.Credit_service.service.ScaleService;
import com.ing.idl.Credit_service.service.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits")
public class CreditController {
    private final CreditService creditService;
    private final ScaleService scaleService;
    private final ScoreService scoreService;

    public CreditController(CreditService creditService, ScaleService scaleService, ScoreService scoreService) {
        this.creditService = creditService;
        this.scaleService = scaleService;
        this.scoreService = scoreService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CreditDto>> createCredit(@RequestBody CreditRequestDto creditRequestDto) {
        ScaleEntity scaleEntity = scaleService.getScale(creditRequestDto.getAmount(), creditRequestDto.getDurationInMonths());
        if (scaleEntity == null) {
            ApiResponse<CreditDto> response = new ApiResponse<>(null, "You can't have credit, there is no scale available with this request.", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
        CreditEntity creditEntity = new CreditEntity(
                creditRequestDto.getCin(),
                scaleEntity.getId(),
                creditRequestDto.getAmount(),
                (scaleEntity.getInterestRate() * creditRequestDto.getAmount())/ 100,
                creditRequestDto.getDurationInMonths());
        CreditDto creditCreated = creditService.addCredit(creditEntity);

        ScoreRequestDto scoreRequestDto = new ScoreRequestDto(
                creditRequestDto.getCin(),
                creditCreated.getId(),
                creditCreated.getMonthlyPayment()
        );
        scoreService.getScore(scoreRequestDto);
        ApiResponse<CreditDto> response = new ApiResponse<>(creditCreated, "Credit created successfully.", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{clientId}")
    public List<CreditDto> getCredits(@PathVariable Long clientId) {
        return creditService.getCreditByClientId(clientId);
    }
}
