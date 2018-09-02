package com.sternkn.spring.multcontext.service;

import org.springframework.stereotype.Service;

@Service
public class SampleService implements ISampleService 
{
    @Override
    public String sayHello(String from) 
    {
        return "Hello from " + from;
    }
}
