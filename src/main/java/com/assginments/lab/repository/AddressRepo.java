package com.assginments.lab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assginments.lab.entity.Address;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {

}
