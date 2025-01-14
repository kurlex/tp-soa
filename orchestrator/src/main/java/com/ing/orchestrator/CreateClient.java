package com.ing.orchestrator;

import com.ing.orchestrator.models.ContractEnum;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;
import com.ing.orchestrator.models.ClientDto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateClient implements JavaDelegate {

    boolean createClient(ClientDto clientDto) {
        String url = "http://localhost:8010/clients";
        RestTemplate restTemplate = new RestTemplate();
        try {
            ClientDto client = restTemplate.postForObject(url, clientDto, ClientDto.class);
            return (client != null);
        } catch (Exception e) {
            System.out.println("Failed to create client: " + e.getMessage() + e.toString());
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
