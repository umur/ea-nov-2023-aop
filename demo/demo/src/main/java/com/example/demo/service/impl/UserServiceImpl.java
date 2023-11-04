package com.example.demo.service.impl;

import com.example.demo.aspect.ExecutionTime;
import com.example.demo.aspect.LogMe;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @ExecutionTime
    @LogMe
    @Override
    public ArrayList<UserDto> getAllUsers() {
        List<User> users =  userRepository.findAll();
        var result = new ArrayList<UserDto>();

        users.forEach(user -> {
            var userDto = modelMapper.map(user, UserDto.class);
            result.add(userDto);
        });
        return result;
    }

    @ExecutionTime
    @LogMe
    @Override
    public UserDto getUserById(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return modelMapper.map(userOptional.orElse(null), UserDto.class);
    }

    @ExecutionTime
    @LogMe
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @ExecutionTime
    @LogMe
    @Override
    public void updateUser(long id, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            // Update user properties with values from updatedUser
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());

            userRepository.save(existingUser);
        }
    }

    @ExecutionTime
    @LogMe
    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
