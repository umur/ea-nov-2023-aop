package com.miu.edu.student.bacha.lab3.services;

import com.miu.edu.student.bacha.lab3.models.Address;
import com.miu.edu.student.bacha.lab3.repositories.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{
    private final AddressRepo addressRepo;
    @Override
    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    @Override
    public Address getAddressById(int id) {
        return addressRepo.findById(id).orElseThrow(()->new RuntimeException("""
                No address with id:${id} exists in the database"""));
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public Address updateAddress(int id, Address address) {
        if(addressRepo.existsById(id)){
            address.setId(id);
            return addressRepo.save(address);
        }
        throw new RuntimeException("""
                Address with id:${id} does not exist.""");
    }

    @Override
    public void delete(int id) {
        addressRepo.deleteById(id);
    }
}
