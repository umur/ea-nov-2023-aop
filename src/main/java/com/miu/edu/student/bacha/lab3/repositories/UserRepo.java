package com.miu.edu.student.bacha.lab3.repositories;

import com.miu.edu.student.bacha.lab3.models.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepo extends ListCrudRepository<User,Integer> {
}
