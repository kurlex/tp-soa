package com.ing.idl.Credit_service.service.impl;

import com.ing.idl.Credit_service.dto.ApiResponse;
import com.ing.idl.Credit_service.dto.ScaleDto;
import com.ing.idl.Credit_service.dto.ScoreDto;
import com.ing.idl.Credit_service.dto.ScoreRequestDto;
import com.ing.idl.Credit_service.entity.ScaleEntity;
import com.ing.idl.Credit_service.mapper.impl.ScaleMapper;
import com.ing.idl.Credit_service.repository.ScaleRepository;
import com.ing.idl.Credit_service.service.ScaleService;
import com.ing.idl.Credit_service.service.ScoreService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;


@Service
public class ScoreServiceImpl implements ScoreService {
    @Override
    public ScoreDto getScore(ScoreRequestDto scoreRequestDto) {
        String url = "http://localhost:8333/scores";
        RestTemplate restTemplate = new RestTemplate();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            HttpEntity<ScoreRequestDto> request = new HttpEntity<>(scoreRequestDto, headers);

            ResponseEntity<ApiResponse<ScoreDto>> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    new ParameterizedTypeReference<ApiResponse<ScoreDto>>() {}
            );

            ApiResponse<ScoreDto> apiResponse = response.getBody();

            if (apiResponse != null && apiResponse.isSuccess()) {
                return apiResponse.getData();
            } else {
                System.err.println("Error: " + (apiResponse != null ? apiResponse.getMessage() : "Unknown error"));
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch score", e);
        }
    }
}
