package com.example.pattern.context;

import com.example.pattern.service.PayService;
import com.example.pattern.service.impl.AliPayServiceImpl;
import com.example.pattern.service.impl.WechatPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PayServiceContext {
    private final Map<String, PayService> paymentMap = new HashMap<>();

    @Autowired
    public PayServiceContext(AliPayServiceImpl alipayPayment, WechatPayServiceImpl wechatPayment) {
        paymentMap.put("alipay", alipayPayment);
        paymentMap.put("wechat", wechatPayment);
    }


    public void pay(String paymentType) {
        PayService payService= paymentMap.get(paymentType);
        if(payService == null){
            throw new RuntimeException("暂不支持该类型支付");
        }else{
            payService.pay();
        }
    }
}
