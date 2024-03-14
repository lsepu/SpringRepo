package com.lsepu.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicationConfig {

    @Bean("testBean")
    @Qualifier("firstBean")
    public TestClass testClass(){
        return new TestClass();
    }

    @Bean
    public TestClass testClassTwo(){
        return new TestClass();
    }
}
