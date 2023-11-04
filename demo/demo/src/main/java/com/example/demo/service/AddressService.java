package com.example.demo.service;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    public List<AddressDto> getAllAddresses();

    public AddressDto getAddressById(long id);
    public void createAddress(Address address);

    public void updateAddress(long id, Address address);

    public void deleteAddress(long id);
}
