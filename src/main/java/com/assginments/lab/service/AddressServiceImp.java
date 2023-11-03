package com.assginments.lab.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.assginments.lab.dto.AddressDto;
import com.assginments.lab.entity.Address;
import com.assginments.lab.repository.AddressRepo;
import com.assginments.lab.service.Interfaces.AddressService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AddressServiceImp implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper mapper;

    // findAll
    public List<AddressDto> findAll() {
        var addresses = addressRepo.findAll();
        List<AddressDto> result = mapper.map(addresses, new TypeToken<List<AddressDto>>() {
        }.getType());
        return result;
    }

    // findById
    public AddressDto findById(int id) {
        var address = addressRepo.findById(id);
        if (address.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return mapper.map(address, AddressDto.class);
    }

    // Add
    public void add(AddressDto newAddress) {
        var address = mapper.map(newAddress, Address.class);
        addressRepo.save(address);
    }

    // update
    public void update(int id, AddressDto updatedAddressDto) {
        if (!addressRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        updatedAddressDto.setId(id);
        var address = mapper.map(updatedAddressDto, Address.class);
        addressRepo.save(address);
    }

    // remove
    public void remove(int id) {
        if (!addressRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        addressRepo.deleteById(id);
    }
}
