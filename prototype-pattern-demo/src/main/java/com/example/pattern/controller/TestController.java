package com.example.pattern.controller;

import com.example.pattern.service.PrototypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 观察控制台是有两个不同的code的，说明是两个对象
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    PrototypeService prototypeService1;

    @Autowired
    PrototypeService prototypeService2;
    @RequestMapping("/test/proto/1")
    public int testSingle1() {
        log.info("code:"+prototypeService1.getCode());
        return prototypeService1.incrementAndGet();
    }
    @RequestMapping("/test/proto/2")
    public int testSingle2() {
        log.info("code:"+prototypeService2.getCode());
        return prototypeService2.incrementAndGet();
    }
}
