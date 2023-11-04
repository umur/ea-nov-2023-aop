package edu.miu.service.impl;

import edu.miu.service.Aop2Service;
import org.springframework.stereotype.Service;

@Service
public class Aop2ServiceImpl implements Aop2Service {
    @Override
    public void demo() {
        System.out.println("inside demo");
    }
    @Override
    public void demoLonger() {
        System.out.println("inside longer demo");
    }

}
