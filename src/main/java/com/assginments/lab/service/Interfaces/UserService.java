package com.assginments.lab.service.Interfaces;

import java.util.List;

import com.assginments.lab.dto.UserDto;

public interface UserService {
    // findAll
    List<UserDto> findAll();

    // findById
    UserDto findById(int id);

    // Add
    void add(UserDto newAddress);

    // update
    void update(int id, UserDto updatedAddressDto);

    // remove
    void remove(int id);
}
