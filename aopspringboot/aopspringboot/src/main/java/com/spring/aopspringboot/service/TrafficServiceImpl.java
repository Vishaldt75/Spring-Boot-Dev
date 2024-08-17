package com.spring.aopspringboot.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficServiceImpl implements TrafficService{

    @Override
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect Heavy Traffic This Morning";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if(tripWire)
        {
            throw new RuntimeException("Major Accident ! Highway is Closed ");
        }
        return getFortune();
    }
}
