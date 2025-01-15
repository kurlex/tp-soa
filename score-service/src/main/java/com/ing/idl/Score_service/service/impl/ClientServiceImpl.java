package com.ing.idl.Score_service.service.impl;

import com.ing.idl.Score_service.dto.ClientDto;
import com.ing.idl.Score_service.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public ClientDto getClientById(Long CIN) {
        String url = "http://localhost:8111/clients/" + CIN;
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, ClientDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch client with CIN " + CIN, e);
        }
    }

}
