package com.assginments.lab.service.Generic;

import java.util.List;

import com.assginments.lab.dto.Generic.GenericDto;
import com.assginments.lab.dto.Generic.GenericNewDto;
import com.assginments.lab.entity.Generic.GenericEntity;

public interface GenericService<TEntity extends GenericEntity, TDto extends GenericDto, TNewEntityDto extends GenericNewDto> {

    Class<TEntity> getTEntityClass();

    Class<TDto> getTDtoClass();

    Class<TNewEntityDto> getTNewEntityDtoClass();

    // findAll
    List<TDto> findAll();

    // findById
    TDto findById(int id);

    // Add
    void add(TNewEntityDto newEntity);

    // update
    void update(int id, TNewEntityDto updateDto);

    // remove
    void remove(int id);
}
