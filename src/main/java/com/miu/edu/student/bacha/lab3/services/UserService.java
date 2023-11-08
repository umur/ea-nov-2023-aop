package com.miu.edu.student.bacha.lab3.services;

import com.miu.edu.student.bacha.lab3.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    User saveUser(User user);
    User updateUser(int id, User user);
    void deleteUser(int id);
}
