package com.ing.idl.Client_service.mapper.impl;

import com.ing.idl.Client_service.dto.ClientDto;
import com.ing.idl.Client_service.entity.ClientEntity;
import com.ing.idl.Client_service.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends GenericMapper<ClientEntity, ClientDto> {
}
