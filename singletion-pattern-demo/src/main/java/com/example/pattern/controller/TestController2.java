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

    @RequestMapping("/test2/single/3")
    public int testSingle3() {
        //这样的话才是另一个对象
        SingletonService singletonService2 = new SingletonService();
        log.info("code:"+singletonService2.getCode());
        return singletonService2.incrementAndGet();
    }
}
