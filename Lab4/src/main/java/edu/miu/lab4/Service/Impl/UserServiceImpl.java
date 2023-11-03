package edu.miu.lab4.Service.Impl;

import edu.miu.lab4.Model.User;
import edu.miu.lab4.Repository.UserRepo;
import edu.miu.lab4.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public User findById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
    return userRepo.updateById(id,user);
    }

    @Override
    public void deleteUser(int id) {
    userRepo.deleteById(id);
    }
}
