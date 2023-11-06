package com.demo1.repository;


import com.demo1.domain.entities.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends ListCrudRepository<Address, Integer> {
}
