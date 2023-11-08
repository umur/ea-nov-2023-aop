package com.miu.edu.student.bacha.lab3.services;

import com.miu.edu.student.bacha.lab3.models.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();
    Address getAddressById(int id);
    Address addAddress(Address address);
    Address updateAddress(int id,Address address);
    void delete(int id);
}
