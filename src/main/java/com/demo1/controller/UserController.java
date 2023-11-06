package com.demo1.controller;


import com.demo1.domain.dto.UserDto;
import com.demo1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public List<UserDto> findAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping()
    public UserDto add(@RequestBody UserDto userDt0) {
        return userService.addUser(userDt0);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable int id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
