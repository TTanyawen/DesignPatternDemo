package com.example.pattern.service.impl;

import com.example.pattern.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WechatPayServiceImpl implements PayService {
    @Override
    public void pay() {
        log.info("微信支付~~~");
    }
}
