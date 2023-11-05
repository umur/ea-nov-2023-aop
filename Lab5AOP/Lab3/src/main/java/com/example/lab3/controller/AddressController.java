package com.example.lab3.controller;

import com.example.lab3.Entity.Address;
import com.example.lab3.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Address> getAddressByUserId(@PathVariable int userId) {
        Address address = addressService.getAddressByUserId(userId);
        if (address != null) {
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address createdAddress = addressService.createAddress(address);
        return ResponseEntity.ok(createdAddress);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<Address> updateAddress(@PathVariable int userId, @RequestBody Address updatedAddress) {
        Address address = addressService.updateAddress(userId, updatedAddress);
        if (address != null) {
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
