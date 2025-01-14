package com.ing.idl.Client_service.controller;

import com.ing.idl.Client_service.dto.ApiResponse;
import com.ing.idl.Client_service.dto.PageableDto;
import com.ing.idl.Client_service.dto.ClientDto;
import com.ing.idl.Client_service.service.ClientService;
import com.ing.idl.Client_service.util.CheckAuthorization;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

   /* @PostMapping
    public ResponseEntity<ApiResponse<ClientDto>> createClient(@RequestBody ClientDto clientDto) {
        clientDto.setId(null);
        ClientDto clientCreated = clientService.addClient(clientDto);
        ApiResponse<ClientDto> response = new ApiResponse<>(clientCreated, "Client created successfully.", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }*/
   @PostMapping
   public ResponseEntity<ApiResponse<ClientDto>> createClient(@RequestBody ClientDto clientDto) {

       boolean clientExists = clientService.clientExistsByCIN(clientDto.getCin());

       if (clientExists) {
           ApiResponse<ClientDto> response = new ApiResponse<>(null, "Client already exists.", false);
           return new ResponseEntity<>(response, HttpStatus.CONFLICT);
       }

       clientDto.setId(null);
       ClientDto clientCreated = clientService.addClient(clientDto);
       ApiResponse<ClientDto> response = new ApiResponse<>(clientCreated, "Client created successfully.", true);
       return new ResponseEntity<>(response, HttpStatus.CREATED);
   }

    @GetMapping(path = "/{cin}")
    public ClientDto getClient(@PathVariable String cin) {
        return clientService.getClientByCIN(cin);
    }
}
