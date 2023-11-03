package com.assginments.lab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assginments.lab.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

}
