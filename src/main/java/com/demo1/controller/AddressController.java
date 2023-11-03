package com.demo1.controller;


import com.demo1.domain.dto.AddressDto;
import com.demo1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/addresses")
public class AddressController {

    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressDto> findAll(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable int id){
        return addressService.getAddressById(id);
    }

    @PostMapping
    public void save(@RequestBody AddressDto addressDto){
        addressService.addAddress(addressDto);
    }

    @PutMapping("/{id}")
    public AddressDto update(@PathVariable int id, @RequestBody AddressDto addressDto){
        return addressService.updateAddress(id, addressDto);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        addressService.deleteAddress(id);
    }
}
