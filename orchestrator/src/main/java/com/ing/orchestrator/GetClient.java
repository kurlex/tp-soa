package com.ing.orchestrator;

import com.ing.orchestrator.models.ClientDto;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;

public class GetClient implements JavaDelegate {

    boolean doesClientExists(String cin) {
        String url = "http://localhost:8010/clients/" + cin;
        RestTemplate restTemplate = new RestTemplate();
        try {
            ClientDto client = restTemplate.getForObject(url, com.ing.orchestrator.models.ClientDto.class);
            return (client != null);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String cin = (String) delegateExecution.getVariable("CIN");
        boolean doesClientExists = doesClientExists(cin);
        delegateExecution.setVariable("doesClientExists", doesClientExists);
    }
}
