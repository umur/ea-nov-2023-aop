package com.miu.lab4aop.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurer {
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
