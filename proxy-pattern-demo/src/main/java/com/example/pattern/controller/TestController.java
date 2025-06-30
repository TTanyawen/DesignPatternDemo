package com.example.pattern.controller;

import com.example.pattern.handler.UserServiceInvocationHandler;
import com.example.pattern.service.UserService;
import com.example.pattern.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

/**
 * 观察控制台是有两个不同的code的，说明是两个对象
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    @Qualifier("UserServiceProxy")
    private UserService UserServiceProxy;
    @RequestMapping("/test/proxy/1")
    public void testSingle1() {
        UserServiceProxy.createUser("谭雅文");
    }
    public static void main(String[] args) {
        // 创建目标对象
        UserService target = new UserServiceImpl();

        // 创建 InvocationHandler 实例
        UserServiceInvocationHandler handler = new UserServiceInvocationHandler(target);

        // 创建代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 类加载器
                target.getClass().getInterfaces(),  // 代理对象需要实现的接口
                handler                             // InvocationHandler 实例
        );

        // 调用代理对象的方法
        proxy.createUser("John");

    }
}
