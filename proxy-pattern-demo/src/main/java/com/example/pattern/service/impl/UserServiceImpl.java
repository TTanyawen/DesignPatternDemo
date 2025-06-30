package com.example.pattern.service.impl;


import com.example.pattern.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public void createUser(String username) {
        log.info("create user: {}", username);
    }
}
