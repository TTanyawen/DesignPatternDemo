package com.example.pattern.service.impl;

import com.example.pattern.conetxt.ValueChainContext;
import com.example.pattern.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AliPayServiceImpl implements PayService {

    @Autowired
    private ValueChainContext valueChainContext;
    @Override
    public void pay() {
//        valueChainContext.handle(10);
//        valueChainContext.handle(-10);
        valueChainContext.handle(null);
        log.info("支付宝支付~~~");
    }
}
