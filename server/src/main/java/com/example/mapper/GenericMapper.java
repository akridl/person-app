package com.example.mapper;

import java.util.List;

public interface GenericMapper<EDIT_DTO, DTO, T> {

    DTO toDto(T entity);

    T toEntity(EDIT_DTO editDto);

    default List<DTO> toListDto(List<T> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
