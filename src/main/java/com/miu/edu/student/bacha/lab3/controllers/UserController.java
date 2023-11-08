package com.miu.edu.student.bacha.lab3.controllers;

import com.miu.edu.student.bacha.lab3.models.User;
import com.miu.edu.student.bacha.lab3.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @PutMapping("{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
    @DeleteMapping
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
