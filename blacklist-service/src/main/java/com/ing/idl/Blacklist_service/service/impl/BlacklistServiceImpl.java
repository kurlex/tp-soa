package com.ing.idl.Blacklist_service.service.impl;

import com.ing.idl.Blacklist_service.dto.BlacklistDto;
import com.ing.idl.Blacklist_service.entity.BlacklistEntity;
import com.ing.idl.Blacklist_service.mapper.impl.BlacklistMapper;
import com.ing.idl.Blacklist_service.repository.BlacklistRepository;
import com.ing.idl.Blacklist_service.service.BlacklistService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlacklistServiceImpl implements BlacklistService {

    private final BlacklistRepository blacklistRepository;
    private final BlacklistMapper blacklistMapper;

    public BlacklistServiceImpl(BlacklistRepository blacklistRepository, BlacklistMapper blacklistMapper) {
        this.blacklistRepository = blacklistRepository;
        this.blacklistMapper = blacklistMapper;
    }


    @Override
    public BlacklistDto addBlacklist(BlacklistDto blacklistDto) {
        BlacklistEntity blacklistEntity = blacklistMapper.toEntity(blacklistDto);
        BlacklistEntity blacklist = blacklistRepository.save(blacklistEntity);
        return blacklistMapper.toDto(blacklist);
    }


    @Override
    public BlacklistDto getBlacklistByClientCIN(Long clientCIN) {
        Optional<BlacklistEntity> blacklistEntityOptional = blacklistRepository.findByClientCIN(clientCIN);

        if (blacklistEntityOptional.isEmpty()) {
            return null;
        }

        BlacklistEntity blacklistEntity = blacklistEntityOptional.get();
        return blacklistMapper.toDto(blacklistEntity);
    }

}
