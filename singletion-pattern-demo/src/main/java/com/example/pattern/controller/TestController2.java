package com.example.pattern.controller;


import com.example.pattern.service.SingletonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController2 {
    @Autowired
    SingletonService singletonService;
    @RequestMapping("/test2/single/1")
    public int testSingle1() {
        log.info("code:"+singletonService.getCode());
        return singletonService.incrementAndGet();
    }
    @RequestMapping("/test2/single/2")
    public int testSingle2() {
        log.info("code:"+singletonService.getCode());
        return singletonService.incrementAndGet();
    }
}
