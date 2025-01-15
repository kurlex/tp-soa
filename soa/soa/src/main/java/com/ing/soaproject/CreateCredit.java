package com.ing.soaproject;

import com.ing.soaproject.models.ApiResponse;
import com.ing.soaproject.models.CreditDto;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Component
public class CreateCredit implements JavaDelegate {

    CreditDto createCredit(CreditDto creditDto) {
        String url = "http://localhost:8222/credits";
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<ApiResponse<CreditDto>> responseEntity =
                    restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(creditDto),
                            new ParameterizedTypeReference<ApiResponse<CreditDto>>() {});

            ApiResponse<CreditDto> responseBody = responseEntity.getBody();
            if (responseBody != null && responseBody.isSuccess()) {
                System.out.println("Credit created successfully: " + responseBody.getData().getId());
                return responseBody.getData();
            } else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long cin = Long.valueOf(delegateExecution.getVariable("CIN").toString());
        Double amount = Double.valueOf(delegateExecution.getVariable("amount").toString());
        Integer durationInMonths = Integer.valueOf(delegateExecution.getVariable("durationInMonths").toString());

        CreditDto creditDto = new CreditDto(cin, amount, durationInMonths);

        CreditDto creditCreated = createCredit(creditDto);
        String creditId = (String) delegateExecution.getVariable("id");
        delegateExecution.setVariable("creditId",creditCreated.getId());
        delegateExecution.setVariable("scaleId",creditCreated.getScaleId());
        delegateExecution.setVariable("interest",creditCreated.getInterest());
        delegateExecution.setVariable("monthlyPayment",creditCreated.getMonthlyPayment());
        delegateExecution.setVariable("score",creditCreated.getScoreDto().getScore());
        delegateExecution.setVariable("creditCreated", creditCreated);

    }
}
