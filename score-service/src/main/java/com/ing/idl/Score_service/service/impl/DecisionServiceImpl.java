package com.ing.idl.Score_service.service.impl;

import com.ing.idl.Score_service.dto.ClientDto;
import com.ing.idl.Score_service.dto.DecisionDto;
import com.ing.idl.Score_service.dto.DecisionRequestDto;
import com.ing.idl.Score_service.service.ClientService;
import com.ing.idl.Score_service.service.DecisionService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DecisionServiceImpl implements DecisionService {

    @Override
    public DecisionDto addDecision(DecisionRequestDto decisionRequestDto) {
        String url = "http://localhost:8005/decisions";
        RestTemplate restTemplate = new RestTemplate();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            HttpEntity<DecisionRequestDto> request = new HttpEntity<>(decisionRequestDto, headers);

            ResponseEntity<DecisionDto> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    DecisionDto.class
            );

            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch score", e);
        }
    }

}
