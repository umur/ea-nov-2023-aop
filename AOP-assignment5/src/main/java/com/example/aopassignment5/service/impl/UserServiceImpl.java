package com.example.aopassignment5.service.impl;

import com.example.aopassignment5.model.User;
import com.example.aopassignment5.repository.UserRepo;
import com.example.aopassignment5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public User findById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
        User user1 = userRepo.findById(id).get();
        if(user1!=null){
            user1.setId(user.getId());
            user1.setEmail(user.getEmail());
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setFirstName(user.getFirstName());



        return userRepo.save(user);
        }
        return user1;
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
}