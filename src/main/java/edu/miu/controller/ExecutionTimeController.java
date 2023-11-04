package edu.miu.controller;

import edu.miu.aop.ExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/executionTime")
public class ExecutionTimeController {
    @GetMapping
    @ExecutionTime
    public String demo() {
        System.out.println("inside demo");
        return "success";
    }
    @GetMapping("/longer")
    @ExecutionTime
    public String longerDemo() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("inside longerDemo");
        return "success";
    }

}
