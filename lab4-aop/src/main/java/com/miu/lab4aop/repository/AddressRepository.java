package com.miu.lab4aop.repository;

import com.miu.lab4aop.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}