package com.assginments.lab.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.assginments.lab.dto.UserDto;
import com.assginments.lab.entity.User;
import com.assginments.lab.repository.UserRepo;
import com.assginments.lab.service.Interfaces.AddressService;
import com.assginments.lab.service.Interfaces.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private final UserRepo userRepo;
    private final AddressService addressService;
    private final ModelMapper mapper;

    // findAll
    public List<UserDto> findAll() {
        var users = userRepo.findAll();
        List<UserDto> result = mapper.map(users, new TypeToken<List<UserDto>>() {
        }.getType());
        return result;
    }

    // findById
    public UserDto findById(int id) {
        if (!userRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        var user = userRepo.findById(id);
        return mapper.map(user, UserDto.class);
    }

    // Add
    public void add(UserDto newUser) {
        var user = mapper.map(newUser, User.class);
        user.getAddress().setUser(user);
        userRepo.save(user);
        // addressService.add(newUser.getAddress());
    }

    // update
    public void update(int id, UserDto updatedUserDto) {
        if (!userRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        updatedUserDto.setId(id);
        var user = mapper.map(updatedUserDto, User.class);
        userRepo.save(user);
    }

    // remove
    public void remove(int id) {
        if (!userRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userRepo.deleteById(id);
    }
}
