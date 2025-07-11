package com.example.pattern.controller;

import com.example.pattern.service.SingletonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证TestController1和TestController2拿到的是同一个单例对象
 * 观察调用4个接口返回的值都在递增，code不变，说明是同一个单例对象
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    SingletonService singletonService;
    @RequestMapping("/test/single/1")
    public int testSingle1() {
        log.info("code:"+singletonService.getCode());
        return singletonService.incrementAndGet();
    }
    @RequestMapping("/test/single/2")
    public int testSingle2() {
        log.info("code:"+singletonService.getCode());
        return singletonService.incrementAndGet();
    }
}
