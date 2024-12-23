package com.ing.idl.BCT_service.controller;

import com.ing.idl.BCT_service.dto.ApiResponse;
import com.ing.idl.BCT_service.dto.BlacklistDto;
import com.ing.idl.BCT_service.service.BCTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bct")
public class BCTController {
    private final BCTService bctService;

    public BCTController(BCTService bctService) {
        this.bctService = bctService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BlacklistDto>> createBlacklist(@RequestBody BlacklistDto blacklistDto) {
        blacklistDto.setId(null);
        BlacklistDto bctCreated = bctService.addBCT(blacklistDto);
        ApiResponse<BlacklistDto> response = new ApiResponse<>(bctCreated, "BCT created successfully.", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/blacklist/{clientCIN}")
    public boolean checkClient(@PathVariable Long clientCIN) {
        return bctService.checkClientInBlacklist(clientCIN);
    }
}
