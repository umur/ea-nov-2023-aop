package com.demo1.repository;

import com.demo1.domain.entities.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo extends ListCrudRepository<User, Integer> {

}
