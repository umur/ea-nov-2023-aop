package com.assginments.lab.service.Generic;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.assginments.lab.dto.Generic.GenericDto;
import com.assginments.lab.dto.Generic.GenericNewDto;
import com.assginments.lab.entity.Generic.GenericEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenericServiceImp<TEntity extends GenericEntity, TDto extends GenericDto, TNewEntityDto extends GenericNewDto, TRepo extends CrudRepository<TEntity, Integer>>
        implements GenericService<TEntity, TDto, TNewEntityDto> {

    private final TRepo repo;
    private final ModelMapper mapper;

    // findAll
    public List<TDto> findAll() {
        var entity = repo.findAll();
        List<TDto> result = new ArrayList<>();

        entity.forEach(x -> {
            result.add(mapper.map(x, getTDtoClass()));
        });

        return result;
    }

    // findById
    public TDto findById(int id) {
        var entity = repo.findById(id);
        if (entity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return mapper.map(entity, getTDtoClass());
    }

    // Add
    public void add(TNewEntityDto newEntityDto) {
        TEntity entity = mapper.map(newEntityDto, getTEntityClass());

        repo.save(entity);
    }

    // update
    public void update(int id, TNewEntityDto updatedDto) {
        throw new UnsupportedOperationException("Unimplemented method 'getTEntityClass'");

        // mapper.getConfiguration().setSkipNullEnabled(true);

        // UserEntity user = userRepo.findById(userId).orElseThrow();
        // // this will tell ModelMapper to map newData into user
        // mapper.map(newData, user);
        // if (!repo.existsById(id)) {
        // throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        // }
        // TEntity entity = mapper.map(updatedAddressDto, getTEntityClass());

        // // entity.setId(id);
        // repo.save(entity);
    }

    // remove
    public void remove(int id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repo.deleteById(id);
    }

    @Override
    public Class<TEntity> getTEntityClass() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTEntityClass'");
    }

    @Override
    public Class<TDto> getTDtoClass() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTDtoClass'");
    }

    @Override
    public Class<TNewEntityDto> getTNewEntityDtoClass() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTNewEntityDtoClass'");
    }

}
