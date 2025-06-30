package com.example.pattern.controller;


import com.example.pattern.factory.PayServiceFactory;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

/**
 * 观察控制台是有两个不同的code的，说明是两个对象
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    PayServiceFactory payServiceFactory;
    @RequestMapping("/test/factory")
    public void testFactory(@RequestParam("type") String type) {
        payServiceFactory.getPayment(type).pay();
    }

}
