package com.ing.soaproject;

import com.ing.soaproject.models.ApiResponse;
import com.ing.soaproject.models.ClientDto;
import com.ing.soaproject.models.ContractEnum;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateClient implements JavaDelegate {

    public boolean createClient(ClientDto clientDto) {
        String url = "http://localhost:8111/clients";
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<ClientDto> responseEntity = restTemplate.postForEntity(url, clientDto, ClientDto.class);


            return responseEntity.getStatusCode() == HttpStatus.CREATED && responseEntity.getBody() != null;
        } catch (HttpClientErrorException | HttpServerErrorException e) {

            System.err.println("HTTP error occurred while creating client: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        } catch (ResourceAccessException e) {

            System.err.println("Failed to connect to the client service: " + e.getMessage());
        } catch (Exception e) {

            System.err.println("Unexpected error occurred while creating client: " + e.getMessage());
        }

        return false;
    }

    @Override
    public void execute(DelegateExecution delegateExecution)  {

        String cin = (String) delegateExecution.getVariable("CIN");
        String firstName = (String) delegateExecution.getVariable("firstName");
        String lastName = (String) delegateExecution.getVariable("lastName");
        Double salary = Double.valueOf(delegateExecution.getVariable("salary").toString());

        String birthdateString = (String) delegateExecution.getVariable("birthdate");

        String contractString = (String) delegateExecution.getVariable("contract");

        ClientDto clientDto = new ClientDto(firstName, lastName, cin, salary, birthdateString, contractString);

        boolean clientCreated = createClient(clientDto);
        delegateExecution.setVariable("clientCreated", clientCreated);
    }

}
