package com.ing.orchestrator;

import com.ing.orchestrator.models.ApiResponse;
import com.ing.orchestrator.models.ScoreDto;
import com.ing.orchestrator.models.ScoreRequestDto;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class GetScore implements JavaDelegate {
    public ScoreDto getScore(ScoreRequestDto scoreRequestDto) {
        String url = "http://localhost:8003/scores";
        RestTemplate restTemplate = new RestTemplate();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

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
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long cin = Long.valueOf(delegateExecution.getVariable("CIN").toString());
        Long creditId = Long.valueOf(delegateExecution.getVariable("creditId").toString());
        Double monthlyPayment = Double.valueOf(delegateExecution.getVariable("monthlyPayment").toString());

        ScoreRequestDto scoreRequestDto = new ScoreRequestDto(
                cin,
                creditId,
                monthlyPayment
        );
        ScoreDto score = getScore(scoreRequestDto);
        if ( score != null ) {
            delegateExecution.setVariable("scoreCreated", true);
            delegateExecution.setVariable("evaluation", score.getEvaluation());
            delegateExecution.setVariable("score", score.getScore());
            delegateExecution.setVariable("scoreId", score.getId());
        }
        else
            delegateExecution.setVariable("scoreCreated", false);
    }
}
