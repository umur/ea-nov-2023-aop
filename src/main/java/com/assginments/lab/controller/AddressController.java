package com.assginments.lab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.assginments.lab.dto.AddressDto;
import com.assginments.lab.service.Interfaces.AddressService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    // findAll
    @GetMapping
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    // findById
    @GetMapping("{id}")
    public AddressDto findByid(@PathVariable int id) {
        return addressService.findById(id);
    }

    // Add
    @PostMapping
    public void addNew(@RequestBody AddressDto addressDto) {
        addressService.add(addressDto);
    }

    // update
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody AddressDto addressDto) {
        addressService.update(id, addressDto);
    }

    // remove
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        addressService.remove(id);
    }

}
