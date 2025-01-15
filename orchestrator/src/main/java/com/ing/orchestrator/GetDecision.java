package com.ing.orchestrator;

import com.ing.orchestrator.models.*;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class GetDecision implements JavaDelegate {
    public DecisionDto addDecision(DecisionRequestDto decisionRequestDto) {
        String url = "http://localhost:8005/decisions";
        RestTemplate restTemplate = new RestTemplate();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<DecisionRequestDto> request = new HttpEntity<>(decisionRequestDto, headers);

            ResponseEntity<ApiResponse<DecisionDto>> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    new ParameterizedTypeReference<ApiResponse<DecisionDto>>() {}
            );

            ApiResponse<DecisionDto> apiResponse = response.getBody();

            if (apiResponse != null && apiResponse.isSuccess()) {
                return apiResponse.getData();
            } else {
                System.err.println("Error: " + (apiResponse != null ? apiResponse.getMessage() : "Unknown error"));
                return null;
            }
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long creditId = Long.valueOf(delegateExecution.getVariable("creditId").toString());
        String evaluation = (String) delegateExecution.getVariable("evaluation");
        DecisionRequestDto decisionRequestDto = new DecisionRequestDto(
                creditId,
                evaluation
        );

        DecisionDto decisionDto = addDecision(decisionRequestDto);
        System.out.println("DecisionDto" + decisionDto.toString());
        if ( decisionDto != null ) {
            delegateExecution.setVariable("decisionCreated", true);
            delegateExecution.setVariable("created_at", decisionDto.getCreated_at());
            delegateExecution.setVariable("decisionId", decisionDto.getId());
            delegateExecution.setVariable("statusDecision", decisionDto.getStatusDecision());
        }
        else
            delegateExecution.setVariable("decisionCreated", false);
    }
}
