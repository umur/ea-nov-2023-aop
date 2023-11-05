package edu.ea.springaop.service;

import edu.ea.springaop.dto.FullUserDto;

import java.util.List;

public interface UserService
{
    List<FullUserDto> findAll();
    FullUserDto findById(Integer id) throws Exception;
    FullUserDto add(FullUserDto userDto);
    FullUserDto update(Integer  id,FullUserDto userDto) throws Exception;
    boolean delete(Integer userId) throws Exception;




}
