package com.miu.lab4aop.repository;

import com.miu.lab4aop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}