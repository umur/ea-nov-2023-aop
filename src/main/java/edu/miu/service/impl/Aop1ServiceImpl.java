package edu.miu.service.impl;

import edu.miu.service.Aop1Service;
import org.springframework.stereotype.Service;

@Service
public class Aop1ServiceImpl implements Aop1Service {
    @Override
    public void demo() {
        System.out.println("inside demo");
    }
    @Override
    public void demoLonger() {
        System.out.println("inside longer demo");
    }

}
