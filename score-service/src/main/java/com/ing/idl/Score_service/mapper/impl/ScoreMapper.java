package com.ing.idl.Score_service.mapper.impl;

import com.ing.idl.Score_service.dto.ScoreDto;
import com.ing.idl.Score_service.entity.ScoreEntity;
import com.ing.idl.Score_service.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScoreMapper extends GenericMapper<ScoreEntity, ScoreDto> {
}
