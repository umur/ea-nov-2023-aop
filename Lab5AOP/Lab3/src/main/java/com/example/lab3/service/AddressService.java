package com.example.lab3.service;

import com.example.lab3.Entity.Address;

public interface AddressService {
    Address getAddressByUserId(int userId);
    Address createAddress(Address address);
    Address updateAddress(int userId,Address updateAddress);
}
