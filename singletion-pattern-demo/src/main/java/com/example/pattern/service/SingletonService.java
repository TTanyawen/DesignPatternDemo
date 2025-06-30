package com.example.pattern.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("singleton")//不加@Scope("singleton")默认是singleton，这里只为了强调
public class SingletonService {

    private int counter = 0;
    private String code= UUID.randomUUID().toString();
    public int incrementAndGet() {
        return ++counter;
    }
    public String getCode() {
        return code;
    }
}