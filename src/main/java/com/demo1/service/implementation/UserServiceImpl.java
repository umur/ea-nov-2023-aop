package com.demo1.service.implementation;
import com.demo1.domain.dto.UserDto;
import com.demo1.domain.entities.User;
import com.demo1.repository.UserRepo;
import com.demo1.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;
    ModelMapper modelMapper;

    @Autowired
    public  UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper){
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        userRepo.findAll().forEach(u->userDtoList.add(modelMapper.map(u, UserDto.class)));
        return userDtoList;
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id" + id));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setId(-1);
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        if(!userRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id:" +id);
        }
        User user = modelMapper.map(userDto, User.class);
        user.setId(-1);
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }


    @Override
    public void deleteUser(int id) {
        if(!userRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id" + id);
        }
        try {
            userRepo.deleteById(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

}
