package com.ing.idl.Score_service.service;

import com.ing.idl.Score_service.dto.ClientDto;

public interface ClientService {
    ClientDto getClientById(Long clientId);
}
