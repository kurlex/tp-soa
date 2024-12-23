package com.ing.idl.Blacklist_service.service.impl;

import com.ing.idl.Blacklist_service.dto.ClientDto;
import com.ing.idl.Blacklist_service.mapper.impl.BlacklistMapper;
import com.ing.idl.Blacklist_service.repository.BlacklistRepository;
import com.ing.idl.Blacklist_service.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientServiceImpl  implements ClientService {

    @Override
    public ClientDto getClientById(Long clientId) {
        String url = "http://localhost:8001/client/" + clientId;
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, ClientDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch client with ID " + clientId, e);
        }
    }


}
