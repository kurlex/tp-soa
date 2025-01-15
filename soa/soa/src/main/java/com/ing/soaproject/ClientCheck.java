package com.ing.soaproject;

import com.ing.soaproject.models.ClientDto;
import com.ing.soaproject.models.ContractEnum;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

public class ClientCheck implements JavaDelegate {


    boolean doesClientExists(String cin) {
        String url = "http://localhost:8111/clients/" + cin;
        RestTemplate restTemplate = new RestTemplate();
        try {
            ClientDto client = restTemplate.getForObject(url, com.ing.soaproject.models.ClientDto.class);
            return (client != null);
        } catch (Exception e) {
            return false;
        }
    }



    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String cin = (String) delegateExecution.getVariable("cin");
       boolean doesClientExists = doesClientExists(cin);
        delegateExecution.setVariable("doesClientExists", doesClientExists);

    }
}