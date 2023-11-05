package com.miu.lab4aop.service;

import com.miu.lab4aop.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);

    void deleteById(Integer id);

    UserDto findById(Integer id);

    List<UserDto> findAll();

    UserDto update(UserDto userDto, Integer id);
}
