package edu.ea.springaop.service;

import edu.ea.springaop.dto.FullAddressDto;

public interface AddressService {


    FullAddressDto  findUserAddress(Integer userId) throws Exception;

    FullAddressDto add(Integer userId,FullAddressDto addressDto) throws Exception;
    FullAddressDto update(Integer addressId,FullAddressDto addressDto) throws Exception;

}
