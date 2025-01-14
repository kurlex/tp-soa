package com.ing.idl.Credit_service.service;

import com.ing.idl.Credit_service.dto.ClientDto;

public interface ClientService {
    ClientDto getClientById(Long clientId);
}
