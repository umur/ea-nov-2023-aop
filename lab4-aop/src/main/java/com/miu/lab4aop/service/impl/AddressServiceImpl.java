package com.miu.lab4aop.service.impl;

import com.miu.lab4aop.aspects.annotations.ExecutionTime;
import com.miu.lab4aop.common.Converter;
import com.miu.lab4aop.dto.AddressDto;
import com.miu.lab4aop.entity.Address;
import com.miu.lab4aop.exceptions.ResourceNotFoundException;
import com.miu.lab4aop.repository.AddressRepository;
import com.miu.lab4aop.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final Converter converter;

    @Override
    public AddressDto save(AddressDto addressDto) {
        Address entity = converter.convert(addressDto, Address.class);
        return converter.convert(repository.save(entity), AddressDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public AddressDto findById(Integer id) {
        return converter.convert(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new), AddressDto.class);
    }

    @ExecutionTime
    @Override
    public List<AddressDto> findByCondition() {
        List<Address> entities = repository.findAll();
        return converter.convertList(entities, AddressDto.class);
    }

    @Override
    public AddressDto update(AddressDto addressDto, Integer id) {
        Optional<Address> data = repository.findById(id);
        Address updatedEntity = data.map(entity -> converter.convert(addressDto, Address.class)).orElseThrow(ResourceNotFoundException::new);
        return save(converter.convert(updatedEntity, AddressDto.class));
    }
}
