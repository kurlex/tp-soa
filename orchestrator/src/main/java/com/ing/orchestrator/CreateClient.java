package com.ing.orchestrator;

import com.ing.orchestrator.models.ApiResponse;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.ing.orchestrator.models.ClientDto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateClient implements JavaDelegate {

    boolean createClient(ClientDto clientDto) {
        String url = "http://localhost:8010/clients";
        RestTemplate restTemplate = new RestTemplate();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<ClientDto> request = new HttpEntity<>(clientDto, headers);

            ResponseEntity<ApiResponse<ClientDto>> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    new ParameterizedTypeReference<ApiResponse<ClientDto>>() {}
            );

            ApiResponse<ClientDto> apiResponse = response.getBody();

            if (apiResponse != null && apiResponse.isSuccess()) {
                return true;
            } else {
                System.err.println("Error: " + (apiResponse != null ? apiResponse.getMessage() : "Unknown error"));
                return false;
            }
        } catch (Exception e) {
            System.err.println("Failed to create client: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String firstName = (String) delegateExecution.getVariable("firstName");
        String lastName = (String) delegateExecution.getVariable("lastName");
        String cin = (String) delegateExecution.getVariable("CIN");
        Double salary = Double.valueOf(delegateExecution.getVariable("salary").toString());

        String birthdateString = (String) delegateExecution.getVariable("birthdate");

        String contractString = (String) delegateExecution.getVariable("contract");

        ClientDto clientDto = new ClientDto(firstName, lastName, cin, salary, birthdateString, contractString);

        boolean clientCreated = createClient(clientDto);
        delegateExecution.setVariable("clientCreated", clientCreated);
    }

}
