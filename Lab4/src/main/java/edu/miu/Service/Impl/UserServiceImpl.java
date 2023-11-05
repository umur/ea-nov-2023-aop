package edu.miu.Service.Impl;

import com.example.lab4.Aspect.ExecutionTime;
import com.example.lab4.Model.User;
import edu.miu.Service.UserService;
import com.example.lab4.Repository.UserRepo;
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
@ExecutionTime
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
