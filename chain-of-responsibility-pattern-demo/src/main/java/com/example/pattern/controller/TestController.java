package com.example.pattern.controller;



import com.example.pattern.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class TestController {

    @Autowired
    private PayService payService;
    @RequestMapping("/test/chain")
    public void testChain() {
        payService.pay();
    }

}
