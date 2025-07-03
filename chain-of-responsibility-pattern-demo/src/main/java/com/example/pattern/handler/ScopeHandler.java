package com.example.pattern.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScopeHandler implements AbtractHandler{
    @Override
    public void handle(Integer value) {
        if(value<0){
            log.info("ScopeHandler value:{} 不满足value>0", value);
            throw new RuntimeException("ScopeHandler 不满足value>0");
        }
        log.info("通过ScopeHandler");
    }

    @Override
    public int getMark() {
        return 20;
    }
}
