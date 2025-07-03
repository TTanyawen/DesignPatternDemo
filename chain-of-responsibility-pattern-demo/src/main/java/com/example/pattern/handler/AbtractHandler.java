package com.example.pattern.handler;

import org.springframework.stereotype.Component;


public interface AbtractHandler {
    void handle(Integer value);

    int getMark();
}
