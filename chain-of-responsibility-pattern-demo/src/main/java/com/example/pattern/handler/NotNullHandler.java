package com.example.pattern.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotNullHandler implements AbtractHandler{
    @Override
    public void handle(Integer value) {
        if(value == null){
            log.info("NotNullHandler value 为null");
            throw new RuntimeException("NotNullHandler value 为null");
        }
        log.info("通过NotNullHandler");
    }

    @Override
    public int getMark() {
        return 10;
    }
}
