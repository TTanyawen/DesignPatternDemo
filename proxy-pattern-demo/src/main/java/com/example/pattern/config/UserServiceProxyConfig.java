package com.example.pattern.config;

import com.example.pattern.handler.UserServiceInvocationHandler;
import com.example.pattern.service.UserService;
import com.example.pattern.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Proxy;

@Configuration
@Slf4j
public class UserServiceProxyConfig {

    /**
     * 创建代理对象
     * @param
     * @return
     */
    @Bean(name="UserServiceProxy")
    public UserService userServiceProxy() {

        UserService target = new UserServiceImpl();
        log.info("创建代理对象... userServiceProxy");
        // 创建 InvocationHandler 实例
        UserServiceInvocationHandler handler = new UserServiceInvocationHandler(target);

        // 创建代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 类加载器
                target.getClass().getInterfaces(),  // 代理对象需要实现的接口
                handler                             // InvocationHandler 实例
        );
        log.info("创建代理对象结束... userServiceProxy");
        return proxy;
    }
}
