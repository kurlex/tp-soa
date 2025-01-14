package com.ing.idl.Client_service.service;

import com.ing.idl.Client_service.dto.PageableDto;
import com.ing.idl.Client_service.dto.ClientDto;
import org.springframework.data.domain.Page;

public interface ClientService {
    ClientDto addClient(ClientDto clientDto);
    ClientDto getClientByCIN(String CIN);


    boolean clientExistsByCIN(String cin);
}
