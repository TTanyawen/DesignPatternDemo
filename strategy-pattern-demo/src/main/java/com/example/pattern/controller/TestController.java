package com.example.pattern.controller;


import com.example.pattern.context.PayServiceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 观察控制台是有两个不同的code的，说明是两个对象
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    PayServiceContext payServiceContext;
    @RequestMapping("/test/strategy")
    public void testFactory(@RequestParam("type") String type) {
        payServiceContext.pay(type);
    }

}
