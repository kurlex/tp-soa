package com.ing.orchestrator;

import com.ing.orchestrator.models.ApiResponse;
import com.ing.orchestrator.models.ClientDto;
import com.ing.orchestrator.models.ScaleDto;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class CreateScale implements JavaDelegate {
    ScaleDto createScale(ScaleDto scaleDto) {
        String url = "http://localhost:8002/scales";
        RestTemplate restTemplate = new RestTemplate();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<ScaleDto> request = new HttpEntity<>(scaleDto, headers);

            System.out.println("hello3");
            ResponseEntity<ApiResponse<ScaleDto>> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    new ParameterizedTypeReference<ApiResponse<ScaleDto>>() {}
            );
            System.out.println("hello1");
            ApiResponse<ScaleDto> apiResponse = response.getBody();
            System.out.println("hello2");

            if (apiResponse != null && apiResponse.isSuccess()) {
                return apiResponse.getData();
            } else {
                System.err.println("Error: " + (apiResponse != null ? apiResponse.getMessage() : "Unknown error"));
                return null;
            }
        } catch (Exception e) {
            System.err.println("Failed to create scale: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Double interestRate = Double.valueOf(delegateExecution.getVariable("interestRate").toString());
        Long minimumDurationInMonths = Long.valueOf(delegateExecution.getVariable("minimumDurationInMonths").toString());
        Long maximumDurationInMonths = Long.valueOf(delegateExecution.getVariable("maximumDurationInMonths").toString());
        Double minimumAmount = Double.valueOf(delegateExecution.getVariable("minimumAmount").toString());
        Double maximumAmount = Double.valueOf(delegateExecution.getVariable("maximumAmount").toString());

        ScaleDto scaleDto = new ScaleDto(interestRate, minimumDurationInMonths, maximumDurationInMonths, minimumAmount, maximumAmount);

        scaleDto = createScale(scaleDto);

        if (scaleDto == null) {
            delegateExecution.setVariable("scaleCreated", false);
        } else {
            delegateExecution.setVariable("scaleCreated", true);
            delegateExecution.setVariable("scaleId", scaleDto.getId());
        }
    }
}
