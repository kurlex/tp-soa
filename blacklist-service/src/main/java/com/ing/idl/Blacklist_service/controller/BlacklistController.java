package com.ing.idl.Blacklist_service.controller;

import com.ing.idl.Blacklist_service.dto.ApiResponse;
import com.ing.idl.Blacklist_service.dto.BlacklistDto;
import com.ing.idl.Blacklist_service.service.BlacklistService;
import com.ing.idl.Blacklist_service.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blacklists")
public class BlacklistController {
    private final BlacklistService blacklistService;
    private final ClientService clientService;

    public BlacklistController(BlacklistService blacklistService, ClientService clientService) {
        this.blacklistService = blacklistService;
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BlacklistDto>> createBlacklist(@RequestBody BlacklistDto blacklistDto) {
        blacklistDto.setId(null);
        BlacklistDto blacklistCreated = blacklistService.addBlacklist(blacklistDto);
        ApiResponse<BlacklistDto> response = new ApiResponse<>(blacklistCreated, "Blacklist created successfully.", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{cin}")
    public BlacklistDto getBlacklist(@PathVariable Long clientCIN) {
        return blacklistService.getBlacklistByClientCIN(clientCIN);
    }
}
