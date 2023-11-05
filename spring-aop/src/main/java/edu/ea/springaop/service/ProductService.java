package edu.ea.springaop.service;



import edu.ea.springaop.dto.FullProductDto;

import java.util.List;

public interface ProductService {
    List<FullProductDto> findAll();
    FullProductDto findById(Integer id) throws Exception;
    FullProductDto add(FullProductDto productDto) throws Exception;
    FullProductDto update(Integer id,FullProductDto productDto) throws Exception;
    boolean delete(Integer id) throws Exception;
}
