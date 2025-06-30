package com.example.pattern.handler;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 实现 InvocationHandler 接口
@Slf4j
public class UserServiceInvocationHandler implements InvocationHandler {
    private Object target; // 目标对象

    public UserServiceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在方法调用前添加额外逻辑
        log.info("Before method: {}" , method.getName());

        // 调用目标对象的方法
        Object result = method.invoke(target, args);

        // 在方法调用后添加额外逻辑
        log.info("After method: {}" , method.getName());

        return result;
    }
}