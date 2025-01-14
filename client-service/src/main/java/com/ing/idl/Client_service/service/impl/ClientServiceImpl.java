package com.ing.idl.Client_service.service.impl;

import com.ing.idl.Client_service.dto.ClientDto;
import com.ing.idl.Client_service.entity.ClientEntity;
import com.ing.idl.Client_service.mapper.impl.ClientMapper;
import com.ing.idl.Client_service.repository.ClientRepository;
import com.ing.idl.Client_service.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDto addClient(ClientDto clientDto) {
        ClientEntity clientEntity = clientMapper.toEntity(clientDto);
        ClientEntity client = clientRepository.save(clientEntity);
        return clientMapper.toDto(client);
    }


    @Override
    public ClientDto getClientByCIN(String cin) {
        Optional<ClientEntity> clientEntityOptional = clientRepository.findByCin(cin);

        if (clientEntityOptional.isEmpty()) {
            return null;
        }

        ClientEntity clientEntity = clientEntityOptional.get();
        return clientMapper.toDto(clientEntity);
    }

    @Override
    public boolean clientExistsByCIN(String cin) {
        return clientRepository.existsByCin(cin);
    }

}
