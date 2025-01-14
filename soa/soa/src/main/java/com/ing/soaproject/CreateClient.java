package com.ing.soaproject;

import com.ing.soaproject.models.ApiResponse;
import com.ing.soaproject.models.ClientDto;
import com.ing.soaproject.models.ContractEnum;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateClient implements JavaDelegate {

    ClientDto createClient(ClientDto c) {
        String url = "http://localhost:8010/clients/";
        RestTemplate restTemplate = new RestTemplate();

        try {
            ApiResponse<ClientDto> response = restTemplate.postForObject(url, c, ApiResponse.class);

            if (response != null && response.isSuccess()) {
                return response.getData();
            } else {
                System.err.println("Error: " + (response != null ? response.getMessage() : "Unknown error"));
                return null;
            }

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        // Get client data from the execution context
        String firstName = (String) delegateExecution.getVariable("firstname");
        String lastName = (String) delegateExecution.getVariable("lastname");
        String cin = (String) delegateExecution.getVariable("cin");
        String salaryStr = (String) delegateExecution.getVariable("salary");
        String birthDateStr = (String) delegateExecution.getVariable("birthdate");  // Assuming birthdate is passed as String
        String contractStr = (String) delegateExecution.getVariable("contract");  // Assuming contract is passed as String


        Double salary = null;
        if (salaryStr != null && !salaryStr.isEmpty()) {
            try {
                salary = Double.parseDouble(salaryStr);
            } catch (NumberFormatException e) {

                System.err.println("Invalid salary value: " + salaryStr);
                salary = 0.0; // default
            }
        }


     /*   Date birthDate = null;
        if (birthDateStr != null && !birthDateStr.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                birthDate = dateFormat.parse(birthDateStr);
            } catch (Exception e) {
                System.err.println("Invalid date format: " + birthDateStr);
                birthDate = new Date();  //  default
            }
        }

        // Convert contract from String to ContractEnum safely
        ContractEnum contract = null;
        if (contractStr != null && !contractStr.isEmpty()) {
            try {
                contract = ContractEnum.valueOf(contractStr);  // Converts the string to the enum constant
            } catch (IllegalArgumentException e) {
                // Handle invalid contract value
                System.err.println("Invalid contract type: " + contractStr);
                contract = ContractEnum.CDI;  // You can set a default value or handle it differently
            }
        }*/


        ClientDto c = new ClientDto(firstName, lastName, cin, salary, birthDateStr, contractStr);


        ClientDto createdClient = createClient(c);

       
        if (createdClient != null) {
            delegateExecution.setVariable("createdClient", createdClient);
        }
    }
}
