package edu.miu.controller;

import edu.miu.aop.ExecutionTime;
import edu.miu.service.Aop1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop1")
@RequiredArgsConstructor
public class Aop1Controller {
    private final Aop1Service aop1Service;
    @GetMapping
    public String demo() {
        aop1Service.demo();
        return "success";
    }
    @GetMapping("/longer")
    public String longerDemo() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        aop1Service.demoLonger();
        return "success";
    }

}
