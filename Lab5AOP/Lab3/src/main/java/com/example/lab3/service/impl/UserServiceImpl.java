package com.example.lab3.service.impl;

import com.example.lab3.Entity.User;
import com.example.lab3.repository.UserRepository;
import com.example.lab3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    public UserRepository userRepository;
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int userId){
        Optional <User> user= userRepository.findById(userId);
        return user.orElse(null);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(int userId, User updateUser){
        Optional<User>existingUser=userRepository.findById(userId);
        if(existingUser.isPresent()){
            User user=existingUser.get();
            user.setEmail(updateUser.getEmail());
            user.setPassword(updateUser.getPassword());
            user.setFirstName(updateUser.getFirstName());
            user.setLastName(updateUser.getLastName());
            return userRepository.save(user);
        }
        else return null;
    }

    public boolean deleteUser(int userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false; // User not found
    }
}
