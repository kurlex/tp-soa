package com.ing.idl.Client_service.mapper;

import java.util.List;

public interface GenericMapper <E, D>{
    D toDto(E entity);
    E toEntity(D dto);
    List<D> toDto(List<E> entities);
    List<E> toEntity(List<D> dtos);
}
