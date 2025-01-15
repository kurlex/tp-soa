package com.ing.orchestrator;

import com.ing.orchestrator.models.ApiResponse;
import com.ing.orchestrator.models.CreditDto;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CreateCredit implements JavaDelegate {

    CreditDto createCredit(CreditDto creditDto) {
        String url = "http://localhost:8002/credits";
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<ApiResponse<CreditDto>> responseEntity =
                    restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(creditDto),
                            new ParameterizedTypeReference<ApiResponse<CreditDto>>() {});

            ApiResponse<CreditDto> responseBody = responseEntity.getBody();
            if (responseBody != null && responseBody.isSuccess()) {
                return responseBody.getData();
            } else {
                System.err.println("Failed to create credit: not success");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Failed to create credit: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long cin = Long.valueOf(delegateExecution.getVariable("CIN").toString());
        Double amount = Double.valueOf(delegateExecution.getVariable("amount").toString());
        Integer durationInMonths = Integer.valueOf(delegateExecution.getVariable("durationInMonths").toString());

        CreditDto creditDto = new CreditDto(cin, amount, durationInMonths);

        CreditDto credit = createCredit(creditDto);

        if (credit != null) {
            delegateExecution.setVariable("creditCreated", true);
            delegateExecution.setVariable("creditId", credit.getId());
            delegateExecution.setVariable("monthlyPayment", credit.getMonthlyPayment());
            delegateExecution.setVariable("interest", credit.getInterest());
            delegateExecution.setVariable("scaleId", credit.getScaleId());
        }
        else {
            delegateExecution.setVariable("creditCreated", false);
        }

    }
}
