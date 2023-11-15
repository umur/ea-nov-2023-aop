package com.example.lab4.Service;

import com.example.lab4.Model.User;

public interface UserService {
    User findById(int id);
    User saveUser(User user);
   // User updateUser(int id,User user);
    void deleteUser(int id);

}
