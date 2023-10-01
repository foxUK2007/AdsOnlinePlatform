package com.example.adsonlineplatform.mappers;

public interface GeneralMapper<Entity, DTO> {

    Entity fromDto(DTO dto);

    DTO toDto(Entity entity);
}