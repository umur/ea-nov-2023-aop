package com.miu.lab4aop.service;

import com.miu.lab4aop.dto.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto save(AddressDto addressDto);

    void deleteById(Integer id);

    AddressDto findById(Integer id);

    List<AddressDto> findByCondition();

    AddressDto update(AddressDto addressDto, Integer id);
}
