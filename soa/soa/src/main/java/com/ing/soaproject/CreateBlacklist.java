package com.ing.soaproject;


import com.ing.soaproject.models.ApiResponse;
import com.ing.soaproject.models.BlacklistDto;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class CreateBlacklist implements JavaDelegate {
    BlacklistDto createBlacklistUser(BlacklistDto blacklistDto) {
        String url = "http://localhost:8444/bct";
        RestTemplate restTemplate = new RestTemplate();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<BlacklistDto> request = new HttpEntity<>(blacklistDto, headers);

            // POST request to add user to the blacklist
            ResponseEntity<ApiResponse<BlacklistDto>> responseEntity =
                    restTemplate.exchange(url, HttpMethod.POST, request,
                            new ParameterizedTypeReference<ApiResponse<BlacklistDto>>() {});

            ApiResponse<BlacklistDto> apiResponse = responseEntity.getBody();

            if (apiResponse != null && apiResponse.isSuccess()) {
                return apiResponse.getData();
            } else {
                System.err.println("Failed to add user to bct");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Failed to add user to bct" + e.getMessage());
            return null;
        }
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long cin = Long.valueOf(delegateExecution.getVariable("CIN").toString());
        BlacklistDto blacklistDto = new BlacklistDto(cin);
        blacklistDto = createBlacklistUser(blacklistDto);
        delegateExecution.setVariable("blacklistCreated", blacklistDto != null);
    }
}
