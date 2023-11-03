package com.assginments.lab;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LabConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
