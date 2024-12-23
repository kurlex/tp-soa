package com.ing.idl.Credit_service.repository;

import com.ing.idl.Credit_service.entity.ScaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScaleRepository extends JpaRepository<ScaleEntity, Long> {
}
