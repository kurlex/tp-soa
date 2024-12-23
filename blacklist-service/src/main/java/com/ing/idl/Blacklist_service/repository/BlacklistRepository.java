package com.ing.idl.Blacklist_service.repository;

import com.ing.idl.Blacklist_service.entity.BlacklistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlacklistRepository extends JpaRepository<BlacklistEntity, Long> {
    Optional<BlacklistEntity> findByCIN(String CIN);
}
