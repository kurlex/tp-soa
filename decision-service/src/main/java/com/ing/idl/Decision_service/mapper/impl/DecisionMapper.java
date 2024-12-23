package com.ing.idl.Decision_service.mapper.impl;

import com.ing.idl.Decision_service.dto.DecisionDto;
import com.ing.idl.Decision_service.entity.DecisionEntity;
import com.ing.idl.Decision_service.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DecisionMapper extends GenericMapper<DecisionEntity, DecisionDto> {
}
