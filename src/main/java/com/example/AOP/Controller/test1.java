package com.example.AOP.Controller;

import com.example.AOP.aspect.LogMe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class test1 {
    @GetMapping
    @LogMe
    public String getTest()
    {
        return "get test run";
    }
    @PostMapping
    public String postTest()
    {
        return "get test run";
    }
}
