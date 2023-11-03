package com.assginments.lab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.assginments.lab.dto.ReviewDto;
import com.assginments.lab.dto.UserDto;
import com.assginments.lab.service.Interfaces.ReviewService;
import com.assginments.lab.service.Interfaces.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ReviewService reviewService;

    // findAll
    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    // findById
    @GetMapping("{id}")
    public UserDto findByid(@PathVariable int id) {
        return userService.findById(id);
    }

    // Add
    @PostMapping
    public void addNew(@RequestBody UserDto userDto) {
        userService.add(userDto);
    }

    // update
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    // remove
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        userService.remove(id);
    }

    @GetMapping("{userId}/reviews")
    public List<ReviewDto> findAllByUserId(@PathVariable int userId) {
        return reviewService.findByUserIdEquals(userId);
    }

}
