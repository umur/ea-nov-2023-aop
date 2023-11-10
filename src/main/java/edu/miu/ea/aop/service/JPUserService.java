package edu.miu.ea.aop.service;

import edu.miu.ea.aop.model.dto.JPUserDTO;

import java.util.List;

public interface JPUserService {

    JPUserDTO add(JPUserDTO userDto);

    JPUserDTO update(Long id, JPUserDTO userDto) throws Exception;

    List<JPUserDTO> findAll();

    JPUserDTO findById(Long id) throws Exception;

    boolean retire(Long id) throws Exception;

}
