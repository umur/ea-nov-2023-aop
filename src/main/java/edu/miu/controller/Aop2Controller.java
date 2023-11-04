package edu.miu.controller;

import edu.miu.aop.ExecutionTime;
import edu.miu.service.Aop2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop2")
@RequiredArgsConstructor
public class Aop2Controller {
    private final Aop2Service aop2Service;

    @GetMapping
    @ExecutionTime
    public String demo() {
        aop2Service.demo();
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
        aop2Service.demoLonger();
        return "success";
    }

}
