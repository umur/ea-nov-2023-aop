package com.example.lab3.service;

import com.example.lab3.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int userId);
    User createUser(User user);
    User updateUser(int userId, User updateUser);
    boolean deleteUser(int userId);

}
