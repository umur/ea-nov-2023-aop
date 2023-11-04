package com.example.demo.service.impl;

import com.example.demo.aspect.ExecutionTime;
import com.example.demo.aspect.LogMe;
import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @ExecutionTime
    @LogMe
    @Override
    public List<AddressDto> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        var result = new ArrayList<AddressDto>();

        addresses.forEach(address -> {
            var addressDto = modelMapper.map(address, AddressDto.class);
            result.add(addressDto);
        });

        return result;
    }

    @ExecutionTime
    @LogMe
    @Override
    public AddressDto getAddressById(long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        return modelMapper.map(addressOptional, AddressDto.class);
    }

    @ExecutionTime
    @LogMe
    @Override
    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    @ExecutionTime
    @LogMe
    @Override
    public void updateAddress(long id, Address updatedAddress) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if (addressOptional.isPresent()) {
            Address existingAddress = addressOptional.get();
            // Update user properties with values from updatedUser
            existingAddress.setCity(updatedAddress.getCity());
            existingAddress.setZip(updatedAddress.getZip());
            existingAddress.setStreet(updatedAddress.getStreet());
            existingAddress.setUser(updatedAddress.getUser());
        }
    }

    @ExecutionTime
    @LogMe
    @Override
    public void deleteAddress(long id) {
        addressRepository.deleteById(id);
    }

}