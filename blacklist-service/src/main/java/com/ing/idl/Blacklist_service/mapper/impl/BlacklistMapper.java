package com.ing.idl.Blacklist_service.mapper.impl;

import com.ing.idl.Blacklist_service.dto.BlacklistDto;
import com.ing.idl.Blacklist_service.entity.BlacklistEntity;
import com.ing.idl.Blacklist_service.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlacklistMapper extends GenericMapper<BlacklistEntity, BlacklistDto> {
}
