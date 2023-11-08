package com.miu.edu.student.bacha.lab3.services;

import com.miu.edu.student.bacha.lab3.models.User;
import com.miu.edu.student.bacha.lab3.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("""
                No user with id=${id} exists"""));
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
        if (userRepo.existsById(id)) {
            user.setId(id);
            return userRepo.save(user);
        }
        throw new RuntimeException("""
                No user with id=${id} exists.""");
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
}
