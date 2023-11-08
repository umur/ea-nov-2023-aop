package com.miu.edu.student.bacha.lab3.controllers;

import com.miu.edu.student.bacha.lab3.models.Address;
import com.miu.edu.student.bacha.lab3.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;
    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }
    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable int id){
        return addressService.getAddressById(id);
    }
    @PostMapping
    public Address addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }
    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable int id, @RequestBody Address address){
        return addressService.updateAddress(id, address);
    }
    @DeleteMapping("/{id}")
    public void deletedAddressById(@PathVariable int id){
        addressService.delete(id);
    }
}
