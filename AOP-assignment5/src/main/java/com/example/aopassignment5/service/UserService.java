package com.example.aopassignment5.service;

import com.example.aopassignment5.model.User;

public interface UserService {
    User findById(int id);
    User saveUser(User user);
    User updateUser(int id,User user);
    void deleteUser(int id);

}
