package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;
    @GetMapping
    public List<AddressDto> getAllUAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public AddressDto getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping
    public void createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable Long id, @RequestBody Address address) {
         addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }

}

