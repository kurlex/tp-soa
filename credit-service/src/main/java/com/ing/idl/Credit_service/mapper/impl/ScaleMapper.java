package com.ing.idl.Credit_service.mapper.impl;

import com.ing.idl.Credit_service.dto.CreditDto;
import com.ing.idl.Credit_service.entity.CreditEntity;
import com.ing.idl.Credit_service.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditMapper extends GenericMapper<CreditEntity, CreditDto> {
}
