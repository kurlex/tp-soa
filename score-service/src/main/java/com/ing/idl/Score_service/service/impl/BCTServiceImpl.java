package com.ing.idl.Score_service.service.impl;

import com.ing.idl.Score_service.dto.*;
import com.ing.idl.Score_service.entity.ScoreEntity;
import com.ing.idl.Score_service.mapper.impl.ScoreMapper;
import com.ing.idl.Score_service.repository.ScoreRepository;
import com.ing.idl.Score_service.service.BCTService;
import com.ing.idl.Score_service.service.ScoreService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BCTServiceImpl implements BCTService {
    @Override
    public boolean checkClient(BlacklistRequestDto blacklistRequestDto) {
        String url = "http://localhost:8004/bct/blacklist/" + blacklistRequestDto.getClientCIN();
        RestTemplate restTemplate = new RestTemplate();
        try {
            Boolean isBlacklisted = restTemplate.getForObject(url, Boolean.class);
            return Boolean.TRUE.equals(isBlacklisted);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch client with CIN " + blacklistRequestDto.getClientCIN(), e);
        }
    }
}
