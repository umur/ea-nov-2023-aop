package com.example.lab3.service.impl;

import com.example.lab3.Entity.Address;
import com.example.lab3.repository.AddressRepository;
import com.example.lab3.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    @Override
    public Address getAddressByUserId(int userId){
        Optional<Address>address=addressRepository.findById(userId);
        return address.orElse(null);
    }

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }
    @Override
    public  Address updateAddress(int userId,Address updateAddress){
        Optional<Address>existingAddress=addressRepository.findById(userId);
        if (existingAddress.isPresent()){
            Address address=existingAddress.get();
            address.setStreet(updateAddress.getStreet());
            address.setZip(updateAddress.getZip());
            address.setCity(updateAddress.getCity());
            return addressRepository.save(address);
        }
        else return null;
    }


}
