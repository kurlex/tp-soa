package com.ing.idl.BCT_service.repository;

import com.ing.idl.BCT_service.entity.BlacklistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BCTRepository extends JpaRepository<BlacklistEntity, Long> {
    Optional<BlacklistEntity> findByClientCIN(Long clientCIN);
}
