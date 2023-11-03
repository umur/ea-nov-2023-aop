package com.demo1.service;




import com.demo1.domain.dto.AddressDto;

import java.util.List;

public interface AddressService {

    List<AddressDto> getAllAddresses();

    AddressDto getAddressById(int id);

    AddressDto addAddress(AddressDto addressDto);

    AddressDto updateAddress(int id, AddressDto addressDto);

    void deleteAddress(int id);

}
