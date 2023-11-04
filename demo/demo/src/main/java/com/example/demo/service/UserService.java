package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public interface UserService {
    public ArrayList<UserDto> getAllUsers();

    public UserDto getUserById(long id);

    public void createUser(User user);

    public void updateUser(long id, User updatedUser);

    public void deleteUser(long id);
}
