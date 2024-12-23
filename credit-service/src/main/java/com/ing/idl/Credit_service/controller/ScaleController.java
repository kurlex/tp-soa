package com.ing.idl.Credit_service.controller;

import com.ing.idl.Credit_service.dto.ApiResponse;
import com.ing.idl.Credit_service.dto.CreditDto;
import com.ing.idl.Credit_service.dto.CreditRequestDto;
import com.ing.idl.Credit_service.dto.ScaleDto;
import com.ing.idl.Credit_service.entity.CreditEntity;
import com.ing.idl.Credit_service.entity.ScaleEntity;
import com.ing.idl.Credit_service.mapper.impl.ScaleMapper;
import com.ing.idl.Credit_service.service.CreditService;
import com.ing.idl.Credit_service.service.ScaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scales")
public class ScaleController {
    private final ScaleService scaleService;

    public ScaleController(ScaleService scaleService) {
        this.scaleService = scaleService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ScaleDto>> createCredit(@RequestBody ScaleDto scaleDto) {
        ScaleDto scaleCreated = scaleService.addScale(scaleDto);
        ApiResponse<ScaleDto> response = new ApiResponse<>(scaleCreated, "Scale created successfully.", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
