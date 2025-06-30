package com.example.pattern.factory;

import com.example.pattern.service.PayService;
import com.example.pattern.service.impl.AliPayServiceImpl;
import com.example.pattern.service.impl.WechatPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PayServiceFactory {
    private final Map<String, PayService> paymentMap = new HashMap<>();

    @Autowired
    public PayServiceFactory(AliPayServiceImpl alipayPayment, WechatPayServiceImpl wechatPayment) {
        paymentMap.put("alipay", alipayPayment);
        paymentMap.put("wechat", wechatPayment);
    }

    public PayService getPayment(String paymentType) {
        return paymentMap.get(paymentType);
    }
}
