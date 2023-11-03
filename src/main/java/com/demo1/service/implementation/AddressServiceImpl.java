package com.demo1.service.implementation;


import com.demo1.domain.dto.AddressDto;
import com.demo1.domain.entities.Address;
import com.demo1.repository.AddressRepo;
import com.demo1.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    AddressRepo addressRepo;
    ModelMapper modelMapper;

    @Autowired
    public AddressServiceImpl(AddressRepo addressRepo, ModelMapper modelMapper){
        this.addressRepo = addressRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<AddressDto> getAllAddresses() {
        List<AddressDto> addressDtoList = new ArrayList<>();
        addressRepo.findAll().forEach(a ->{
            addressDtoList.add(modelMapper.map(a,AddressDto.class));
        });
        return addressDtoList;
    };

    @Override
    public AddressDto getAddressById(int id) {
        Address address = addressRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address Not Found with this id" + id));
        return modelMapper.map(address, AddressDto.class);
    };

    @Override
    public AddressDto addAddress(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        address.setId(-1);
        Address savedAddress = addressRepo.save(address);
        return modelMapper.map(savedAddress, AddressDto.class);
    };

    @Override
    public AddressDto updateAddress(int id, AddressDto addressDto) {
        if(!addressRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found with id:" + id);
        };
        Address address = modelMapper.map(addressDto, Address.class);
        address.setId(-1);
        Address savedAddress = addressRepo.save(address);
        return modelMapper.map(savedAddress, AddressDto.class);
    };

    @Override
    public void deleteAddress(int id) {
        if (!addressRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found with id: " + id);
        };
        addressRepo.deleteById(id);
    };
}
