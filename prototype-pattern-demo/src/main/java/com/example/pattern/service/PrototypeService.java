package com.example.pattern.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * //指定为prototype，
 * 每次通过注解注入都会创建一个新对象，实例化时机是@Autowired注入的时候
 * 但是单例模式的Bean就是在Spring容器启动的时候实例化的
 */
@Component
@Scope("prototype")
public class PrototypeService {

    private int counter = 0;
    private String code= UUID.randomUUID().toString();
    public int incrementAndGet() {
        return ++counter;
    }
    public String getCode() {
        return code;
    }
}